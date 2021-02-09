package com.test.caixaeletronico.config;


import com.test.caixaeletronico.resthttp.exception.BeneficiarioNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;



@ControllerAdvice
class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeneficiarioNotFoundException.class)
    public ResponseEntity<Object> handleBeneficiarioNaoEncontradoException(BeneficiarioNotFoundException ex, WebRequest request) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Resource Not Found");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> ArithmeticException(ArithmeticException ex, WebRequest request) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Arithmetic Error");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HashMap<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Erro na requisição");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
