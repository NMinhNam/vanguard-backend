package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDtoRequest {
    private String email;
    private String currentPassword;
    private String newPassword;
    private Integer OTP;
}
