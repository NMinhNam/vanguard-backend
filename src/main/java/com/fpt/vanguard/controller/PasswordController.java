package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.PasswordDtoRequest;
import com.fpt.vanguard.service.PasswordService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping("change-password")
    public ApiResponse<Integer> changePassword(@RequestBody PasswordDtoRequest passwordDto) {
        return ApiResponse.<Integer>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(passwordService.changePassword(passwordDto))
                .build();
    }

    @PostMapping("forgot-password")
    public ApiResponse<Void> forgotPassword(@RequestBody PasswordDtoRequest passwordDto) throws MessagingException {
        return ApiResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(passwordService.forgotPassword(passwordDto))
                .build();
    }
}
