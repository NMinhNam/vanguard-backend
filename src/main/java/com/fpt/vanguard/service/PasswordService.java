package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PasswordDtoRequest;
import jakarta.mail.MessagingException;

public interface PasswordService {
    Integer changePassword(PasswordDtoRequest passwordDtoRequest);
    Void forgotPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException;
}
