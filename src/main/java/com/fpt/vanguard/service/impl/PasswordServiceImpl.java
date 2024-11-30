package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.request.PasswordDtoRequest;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mybatis.PasswordMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.PasswordService;
import com.fpt.vanguard.util.OtpGenerateUtil;
import com.fpt.vanguard.util.PasswordUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final PasswordMapper passwordMapper;
    private final MailService mailService;

    @Override
    public Integer changePassword(PasswordDtoRequest passwordDtoRequest) {
        String email = passwordDtoRequest.getEmail();
        String curPassword = passwordDtoRequest.getCurrentPassword();
        String newPassword = passwordDtoRequest.getNewPassword();

        boolean isMatchPassword = passwordMapper.checkPassword(email, curPassword);
        if (!isMatchPassword) throw new AppException(ErrorCode.PASSWORD_NOT_VALID);

        String newPwd = PasswordUtil.hashPassword(newPassword);
        passwordDtoRequest.setNewPassword(newPwd);
        return passwordMapper.changePassword(newPwd, email);
    }

    @Override
    public Void forgotPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException {
        String email = passwordDtoRequest.getEmail();
        Boolean isExistEmail = passwordMapper.isMailExist(email);
        if (!isExistEmail) throw new AppException(ErrorCode.USER_NOT_EXIST);

        Integer otp = OtpGenerateUtil.generateOTP();
        passwordDtoRequest.setOTP(otp);

        return sendForgotPasswordEmail(passwordDtoRequest);
    }

    private Void sendForgotPasswordEmail(PasswordDtoRequest passwordDtoRequest) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", passwordDtoRequest.getEmail());
        variables.put("otp", passwordDtoRequest.getOTP());

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder()
                .to(passwordDtoRequest.getEmail())
                .subject("OTP Verification")
                .templateName("password-reset.html")
                .variables(variables).build();

        mailService.sendMail(mailDtoRequest);
        return null;
    }
}
