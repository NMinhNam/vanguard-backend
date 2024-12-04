package com.fpt.vanguard.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OtpDtoResponse {
    private Integer otp;
    private LocalDateTime expiryTime;
}
