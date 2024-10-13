package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.request.IntrospectDtoRequest;
import com.fpt.vanguard.dto.request.LogoutDtoRequest;
import com.fpt.vanguard.dto.request.RefreshDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.dto.response.IntrospectDtoResponse;
import com.fpt.vanguard.entity.InvalidatedToken;
import com.fpt.vanguard.entity.User;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.mapper.mybatis.InvalidatedTokenMapper;
import com.fpt.vanguard.mapper.mybatis.UserMapper;
import com.fpt.vanguard.service.AuthenticationService;
import com.fpt.vanguard.util.FormatDate;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final InvalidatedTokenMapper tokenMapper;

    @Value("${jwt.signer-key}")
    protected String SECRET_KEY;

    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = userMapper.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) throw new AppException(ErrorCode.PASSWORD_INCORRECT);
        var accessToken = generateToken(user);
        return AuthenticationDtoResponse.builder()
                .token(accessToken)
                .build();
    }

    private String generateToken(User user) throws JOSEException {
        var roleName = user.getRole().getRoleName();
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserName())
                .issueTime(new Date())
                .expirationTime(Date
                                .from(Instant.now()
                                .plus(1, ChronoUnit.HOURS)))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", roleName)
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
        return jwsObject.serialize();
    }

    @Override
    public Void logout(LogoutDtoRequest request) throws ParseException, JOSEException {
        var signedJWT = verifyToken(request.getToken());
        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        Date expirationTimeNonFormat = signedJWT.getJWTClaimsSet().getExpirationTime();
        var expTime = FormatDate.convertDateToTimestamp(expirationTimeNonFormat);
        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jwtId)
                .expTime(expTime)
                .build();
        tokenMapper.insertInvalidatedToken(invalidatedToken);
        return null;
    }

    @Override
    public IntrospectDtoResponse introspect(IntrospectDtoRequest request) throws JOSEException, ParseException {
        String token = request.getToken();
        verifyToken(token);
        return IntrospectDtoResponse.builder()
                .valid(true)
                .build();
    }

    @Override
    public AuthenticationDtoResponse refresh(RefreshDtoRequest request) throws ParseException, JOSEException {
        SignedJWT signedJWT = verifyToken(request.getToken());
        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        Date expTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jwtId)
                .expTime(expTime)
                .build();
        tokenMapper.insertInvalidatedToken(invalidatedToken);
        String username = signedJWT.getJWTClaimsSet().getSubject();
        var user = userMapper.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        var refreshToken = generateToken(user);
        return AuthenticationDtoResponse.builder()
                .token(refreshToken)
                .build();
    }

    private SignedJWT verifyToken(String token) throws JOSEException, ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());
        Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verified = signedJWT.verify(verifier);
        if (!verified && expiration.before(new Date()))
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        if (tokenMapper.isInvalidatedTokenExists(signedJWT.getJWTClaimsSet().getJWTID()))
            throw new AppException(ErrorCode.INVALID_TOKEN);
        return signedJWT;
    }

}
