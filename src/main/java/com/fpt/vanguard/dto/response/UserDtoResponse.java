package com.fpt.vanguard.dto.response;

import com.fpt.vanguard.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoResponse {
    private Integer userId;
    private String userName;
    private String email;
    private Boolean enabled;
    private Role role;
}
