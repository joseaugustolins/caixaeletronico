package com.test.caixaeletronico.resthttp;

import com.test.caixaeletronico.model.AporteRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RestRequestBeneficiario {
    public ResponseEntity requestPut(String uri, HttpEntity<?> payload);
    public ResponseEntity requestGetById(String uri);
}

