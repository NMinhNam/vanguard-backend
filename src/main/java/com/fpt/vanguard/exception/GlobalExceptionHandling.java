package com.fpt.vanguard.exception;

import com.fpt.vanguard.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handleAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(errorCode.getStatus());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handleException(RuntimeException e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(ErrorCode.UNCAUGHT_EXCEPTION.getStatus());
        apiResponse.setMessage(ErrorCode.UNCAUGHT_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    ResponseEntity<ApiResponse> handleBadSqlGrammarException(BadSqlGrammarException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse.builder()
                        .status(ErrorCode.BAD_SQL.getStatus())
                        .message(ErrorCode.BAD_SQL.getMessage())
                        .build());
    }
}
