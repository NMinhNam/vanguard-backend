package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.MailDtoRequest;
import com.fpt.vanguard.dto.response.MailDtoResponse;
import com.fpt.vanguard.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    public MailDtoResponse sendMail(MailDtoRequest request) throws MessagingException {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());

            Context context = new Context();
            context.setVariables(request.getVariables());
            String htmlContent = templateEngine.process(request.getTemplateName(), context);
            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);

            return MailDtoResponse.builder()
                    .success(true)
                    .build();
    }
}
