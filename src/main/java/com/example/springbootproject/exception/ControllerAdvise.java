package com.example.springbootproject.exception;

import com.example.springbootproject.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
           ErrorDTO errorDTO = ErrorDTO.builder()
                   .campo("500")
                   .message(ex.getMessage())
                   .build();
           return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
