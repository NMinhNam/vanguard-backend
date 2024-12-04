package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.OtpDtoRequest;
import com.fpt.vanguard.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/otp")
@RequiredArgsConstructor
@CrossOrigin
public class OtpController {
    private final OtpService otpService;

    @PostMapping("/validate")
    public ApiResponse<Boolean> validateOtp(@RequestBody OtpDtoRequest request) {
        return ApiResponse.<Boolean>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(otpService.isValidOtp(request))
                .build();
    }
}
