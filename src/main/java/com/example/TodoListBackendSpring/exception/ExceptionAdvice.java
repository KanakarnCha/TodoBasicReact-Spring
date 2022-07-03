package com.example.TodoListBackendSpring.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<ErrorModel> responseError(BaseException exception){
        ErrorModel errorModel = new ErrorModel();
        errorModel.setError(exception.getMessage());
        errorModel.setStatus(String.valueOf(HttpStatus.EXPECTATION_FAILED));
        return new ResponseEntity<>(errorModel,HttpStatus.EXPECTATION_FAILED);
    }
    @Data
    public static class ErrorModel{
        private String error;
        private String status;
        private final LocalDateTime localDateTime = LocalDateTime.now();

    }
}
