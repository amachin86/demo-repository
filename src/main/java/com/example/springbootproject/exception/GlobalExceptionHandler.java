package com.example.springbootproject.exception;

import com.example.springbootproject.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new HashMap<>();

        List<ErrorDTO> listErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map( x -> ErrorDTO.builder().message(x.getDefaultMessage()).campo(x.getField()).build())
                .collect(Collectors.toList());

        body.put("errors", listErrors);
        return new ResponseEntity<>(body, headers, status);

    }
}
