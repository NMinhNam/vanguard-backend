package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.request.IntrospectDtoRequest;
import com.fpt.vanguard.dto.request.LogoutDtoRequest;
import com.fpt.vanguard.dto.request.RefreshDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.dto.response.IntrospectDtoResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException;
    Void logout(LogoutDtoRequest request) throws ParseException, JOSEException;
    IntrospectDtoResponse introspect(IntrospectDtoRequest request) throws JOSEException, ParseException;
    AuthenticationDtoResponse refresh(RefreshDtoRequest request) throws ParseException, JOSEException;
}
