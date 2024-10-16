package com.fpt.vanguard.service;

import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.MailDtoResponse;
import jakarta.mail.MessagingException;

public interface MailService {
    MailDtoResponse sendWelcomeMail(MailDtoRequest request) throws MessagingException;
}
