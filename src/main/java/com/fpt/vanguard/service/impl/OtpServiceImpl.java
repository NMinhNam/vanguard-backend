package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.OtpDtoRequest;
import com.fpt.vanguard.entity.Otp;
import com.fpt.vanguard.enums.ErrorCode;
import com.fpt.vanguard.exception.AppException;
import com.fpt.vanguard.mapper.mybatis.OtpMapper;
import com.fpt.vanguard.service.CaptchaService;
import com.fpt.vanguard.service.OtpService;
import com.fpt.vanguard.util.OtpGenerateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
    private final OtpMapper otpMapper;
    private final CaptchaService captchaService;

    @Override
    public Integer generateAndSaveOtp(String email) {
        Integer otp = OtpGenerateUtil.generateOTP();
        LocalDateTime expiryTime = LocalDateTime.now().plusSeconds(30);

        Otp otpEntity = Otp.builder()
                .email(email)
                .otp(otp)
                .expiryTime(expiryTime)
                .build();
        otpMapper.insertOtp(otpEntity);
        return otp;
    }

    @Override
    public Boolean isValidOtp(OtpDtoRequest request) {
        String email = request.getEmail();
        Integer otp = request.getOtp();

        Otp otpEntity = otpMapper.findLatestOtpByEmail(email);

        if (otpEntity.getExpiryTime().isBefore(LocalDateTime.now())) {
            otpMapper.deleteOtp(email);
            throw new AppException(ErrorCode.OTP_EXPIRED);
        }

        if (!otpEntity.getOtp().equals(otp)) {
            throw new AppException(ErrorCode.OTP_NOT_VALID);
        }

        return true;
    }
}
