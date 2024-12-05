package com.fpt.vanguard.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Otp {
    private Long id;
    private String email;
    private Integer otp;
    private LocalDateTime expiryTime;
    private LocalDateTime createdTime;
}
