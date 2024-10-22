package com.fpt.vanguard.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private Boolean enabled;
    private Role role;
}
