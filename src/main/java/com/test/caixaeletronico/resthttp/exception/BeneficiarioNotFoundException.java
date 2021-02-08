package com.test.caixaeletronico.resthttp.exception;

public class BeneficiarioNotFoundException extends RuntimeException{
    public BeneficiarioNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
