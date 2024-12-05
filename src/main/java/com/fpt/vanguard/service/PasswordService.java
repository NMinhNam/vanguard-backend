package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.PasswordDtoRequest;
import jakarta.mail.MessagingException;

public interface PasswordService {
    Integer changePassword(PasswordDtoRequest passwordDtoRequest);
    Integer forgotPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException;
    Integer resetPassword(PasswordDtoRequest passwordDtoRequest) throws MessagingException;
}
