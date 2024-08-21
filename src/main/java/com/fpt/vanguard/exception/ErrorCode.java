package com.fpt.vanguard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS(200, "Success"),
    FAIL(500, "Fail"),
    HTTP_STATUS_200(200, "ok"),
    HTTP_STATUS_400(400, "request error"),
    HTTP_STATUS_401(401, "no authentication"),
    HTTP_STATUS_403(403, "no authorities"),
    HTTP_STATUS_500(500, "server error"),
    UNCAUGHT_EXCEPTION(999, "uncaught exception"),
    NHAN_VIEN_NOT_EXIST(500, "nhan vien khong ton tai"),
    LIST_NHAN_VIEN_EMPTY(888, "list nhan vien rong");

    private final int status;
    private final String message;
}
