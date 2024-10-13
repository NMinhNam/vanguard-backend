package com.fpt.vanguard.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshDtoRequest {
    private String refreshToken;
}
