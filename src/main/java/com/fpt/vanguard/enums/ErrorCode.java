package com.fpt.vanguard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCAUGHT_EXCEPTION(999, "uncaught exception"),
    NHAN_VIEN_NOT_EXIST(1000, "nhan vien khong ton tai"),
    NHAN_VIEN_EXISTED(1001, "nhan vien da ton tai"),
    LIST_NHAN_VIEN_EMPTY(1002, "list nhan vien rong"),
    LIST_BO_PHAN_EMPTY(1002, "list bo phan rong"),
    BO_PHAN_NOT_EXIST(1000, "bo phan khong ton tai"),
    DATE_EXCEPTION(999, "date exception"),
    USER_NOT_EXIST(1000, "user not exist"),
    PASSWORD_INCORRECT(9999, "password incorrect"),
    JOSE_EXCEPTION(999, "Cannot sign JWT"),
    BAD_SQL(500, "bad sql"),
    LIST_USER_EMPTY(1002, "List user empty")
    ;

    private final int status;
    private final String message;
}
