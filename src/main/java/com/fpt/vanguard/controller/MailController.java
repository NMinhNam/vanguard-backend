package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.MailDtoResponse;
import com.fpt.vanguard.service.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
@Component
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping
    public ApiResponse<MailDtoResponse> sendMail(@RequestBody MailDtoRequest request) throws MessagingException {
        return ApiResponse.<MailDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(mailService.sendMail(request))
                .build();
    }
}
