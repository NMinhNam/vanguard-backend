package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.request.PasswordDtoRequest;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mybatis.PasswordMapper;
import com.fpt.vanguard.service.MailService;
import com.fpt.vanguard.service.OtpService;
import com.fpt.vanguard.service.PasswordService;
import com.fpt.vanguard.util.OtpGenerateUtil;
import com.fpt.vanguard.util.PasswordUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final PasswordMapper passwordMapper;
    private final MailService mailService;
    private final OtpService otpService;

    @Override
    public Integer changePassword(PasswordDtoRequest passwordDtoRequest) {
        String email = passwordDtoRequest.getEmail();
        String curPassword = passwordDtoRequest.getCurrentPassword();
        String newPassword = passwordDtoRequest.getNewPassword();

        boolean isMatchPassword = passwordMapper.checkPassword(email, curPassword);
        if (!isMatchPassword) throw new AppException(ErrorCode.PASSWORD_NOT_VALID);

        String hashedPassword = PasswordUtil.hashPassword(newPassword);
        return passwordMapper.changePassword(hashedPassword, email);
    }

    @Override
    public Integer forgotPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException {
        String email = passwordDtoRequest.getEmail();
        Boolean isExistEmail = passwordMapper.isMailExist(email);
        if (!isExistEmail) throw new AppException(ErrorCode.USER_NOT_EXIST);

        Integer otp = otpService.generateAndSaveOtp(email);
        passwordDtoRequest.setOTP(otp);
        sendForgotPasswordEmail(passwordDtoRequest);

        return otp;
    }

    @Override
    public Integer resetPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException {
        String mail = passwordDtoRequest.getEmail();
        String password = passwordDtoRequest.getNewPassword();
        String hashedPassword = PasswordUtil.hashPassword(password);
        return passwordMapper.changePassword(mail, hashedPassword);
    }

    private void sendForgotPasswordEmail(PasswordDtoRequest passwordDtoRequest) throws MessagingException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("name", passwordDtoRequest.getEmail());
        variables.put("otp", passwordDtoRequest.getOTP());

        MailDtoRequest mailDtoRequest = MailDtoRequest.builder()
                .to(passwordDtoRequest.getEmail())
                .subject("OTP Verification")
                .templateName("password-reset.html")
                .variables(variables).build();

        mailService.sendMail(mailDtoRequest);
    }
}
