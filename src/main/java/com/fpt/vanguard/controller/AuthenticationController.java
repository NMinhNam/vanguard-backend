package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.request.IntrospectDtoRequest;
import com.fpt.vanguard.dto.request.LogoutDtoRequest;
import com.fpt.vanguard.dto.request.RefreshDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.dto.response.IntrospectDtoResponse;
import com.fpt.vanguard.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

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

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestBody LogoutDtoRequest request) throws ParseException, JOSEException {
        return ApiResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(authenticationService.logout(request))
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectDtoResponse> logout(@RequestBody IntrospectDtoRequest request) throws ParseException, JOSEException {
        return ApiResponse.<IntrospectDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(authenticationService.introspect(request))
                .build();
    }

    @PostMapping("/refresh")
    public ApiResponse<AuthenticationDtoResponse> refresh(@RequestBody RefreshDtoRequest request) throws ParseException, JOSEException {
        return ApiResponse.<AuthenticationDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(authenticationService.refresh(request))
                .build();
    }
}
