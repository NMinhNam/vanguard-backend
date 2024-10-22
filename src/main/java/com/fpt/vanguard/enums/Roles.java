package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Roles {
    ADMIN(1),
    MANAGER(3),
    USER(2)
    ;

    private final Integer roleId;
}
