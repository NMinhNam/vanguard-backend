package com.fpt.vanguard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoRequest {
    private String username;
    private String password;
    private String email;
    private Integer roleId;
}
