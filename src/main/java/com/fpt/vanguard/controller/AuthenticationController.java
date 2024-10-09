package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationDtoResponse> login(@RequestBody AuthenticationDtoRequest request) throws JOSEException {
        return ApiResponse.<AuthenticationDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(authenticationService.authenticate(request))
                .build();
    }
}
