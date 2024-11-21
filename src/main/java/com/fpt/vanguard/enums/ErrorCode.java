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
    LIST_PHONG_BAN_EMPTY(1002, "list phong ban rong"),
    LIST_TUYEN_DUNG_EMPTY(1002,"LIST TUYEN DUNG RONG"),
    LIST_HOP_DONG_EMPTY(1002,"LIST HOP DONG RONG"),
    HOP_DONG_NOT_EXIST(1000,"HOP DONG KHONG TON TAI"),
    TUYEN_DUNG_NOT_EXIST(1000,"TUYEN DUNG KHONG TON TAI"),
    PHONG_BAN_NOT_EXIST(1000, "phong ban khong ton tai"),
    BO_PHAN_NOT_EXIST(1000, "bo phan khong ton tai"),
    LIST_UNG_LUONG_EMPTY(1002, "list ung luon rong"),
    UNG_LUONG_NOT_EXIST(1000, "ung luon khong ton tai"),
    DATE_EXCEPTION(999, "date exception"),
    USER_NOT_EXIST(1000, "user not exist"),
    USER_EXISTED(1001, "user da ton tai"),
    PASSWORD_INCORRECT(9999, "password incorrect"),
    JOSE_EXCEPTION(999, "Cannot sign JWT"),
    BAD_SQL(500, "bad sql"),
    LIST_USER_EMPTY(1002, "List user empty"),
    ACCESS_DENIED(1003, "Access denied"),
    UNAUTHENTICATED(1003, "unauthenticated"),
    INVALID_TOKEN(1003, "invalid token"),
    RESOURCE_NOT_FOUND(1004, "resource not found! Endpoints fail"),
    ACCOUNT_HAS_BEEN_DISABLE(1003, "Tai khoan da bi vo hieu hoa"),
    MAIL_EXCEPTION(999, "mail exception"),
    EMAIL_EXISTED(1001, "email existed"),
    DON_YEU_CAU_NOT_EXIST(1000, "Don yeu cau not exist"),
    DON_YEU_CAU_EXISTED(1001, "Don yeu cau existed"),
    LIST_UNG_VIEN_EMPTY(1002, "list ung vien rong"),
    FILE_UPLOAD_FAILED(999, "file upload failed"),
    DU_UNG_VIEN_DAT_YEU_CAU(1111, "Ung vien dat yeu cau qua gioi han"),
    UNG_VIEN_KHONG_TON_TAI(1003, "Ung vien khong ton tai")
    ;

    private final int status;
    private final String message;
}
