package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MailDtoRequest {
    private String to;
    private String subject;
    private String body;
    private String templateName;
    Map<String, Object> variables;
}
