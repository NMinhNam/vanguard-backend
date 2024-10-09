package com.fpt.vanguard.exception;

import com.fpt.vanguard.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends RuntimeException {
    private ErrorCode errorCode;
}
