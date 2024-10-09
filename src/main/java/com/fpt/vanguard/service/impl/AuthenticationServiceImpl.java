package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.entity.User;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.mapper.mybatis.UserMapper;
import com.fpt.vanguard.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.signer-key}")
    protected String SECRET_KEY;

    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException {
        var user = userMapper.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXIST));
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) throw new AppException(ErrorCode.PASSWORD_INCORRECT);
        var token = generateToken(user);
        return AuthenticationDtoResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public String generateToken(User user) throws JOSEException {
        var roleName = user.getRole().getRoleName();
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserName())
                .issueTime(new Date())
                .expirationTime(Date
                                .from(Instant.now()
                                .plus(1, ChronoUnit.HOURS)))
                .claim("scope", roleName)
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
        return jwsObject.serialize();
    }

}
