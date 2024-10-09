package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.AuthenticationDtoRequest;
import com.fpt.vanguard.dto.response.AuthenticationDtoResponse;
import com.fpt.vanguard.entity.User;
import com.nimbusds.jose.JOSEException;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException;
    String generateToken(User userName) throws JOSEException;
}
