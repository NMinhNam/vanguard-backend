package com.fpt.vanguard.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDtoRequest {
    private String username;
    private String password;
    private Integer roleId;
}
