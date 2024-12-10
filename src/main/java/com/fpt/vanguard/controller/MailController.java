package com.fpt.vanguard.controller;

import com.fpt.vanguard.common.ApiResponse;
import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.MailDtoResponse;
import com.fpt.vanguard.service.EmailListenerService;
import com.fpt.vanguard.service.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mail")
@Component
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final EmailListenerService emailListenerService;

    @GetMapping("/start-listening")
    public String startListening() {
        // Khởi chạy lắng nghe email
        new Thread(() -> emailListenerService.startListening()).start();
        return "Started listening for new emails.";
    }
    @PostMapping
    public ApiResponse<MailDtoResponse> sendMail(@RequestBody MailDtoRequest request) throws MessagingException {
        return ApiResponse.<MailDtoResponse>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .data(mailService.sendMail(request))
                .build();
    }
}
