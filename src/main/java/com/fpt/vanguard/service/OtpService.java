package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.OtpDtoRequest;

public interface OtpService {
    Integer generateAndSaveOtp(String email);
    Boolean isValidOtp(OtpDtoRequest request);
}
