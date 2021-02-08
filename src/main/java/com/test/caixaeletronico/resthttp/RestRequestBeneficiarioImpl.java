package com.test.caixaeletronico.resthttp;

import com.test.caixaeletronico.model.BeneficiarioDTO;
import com.test.caixaeletronico.resthttp.exception.BeneficiarioNotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestRequestBeneficiarioImpl implements RestRequestBeneficiario {

    @Override
    public ResponseEntity requestPut(String uri, HttpEntity<?> payload){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<BeneficiarioDTO> result = restTemplate.exchange(uri, HttpMethod.PUT, payload, BeneficiarioDTO.class);
        return result;
    }

    @Override
    public ResponseEntity requestGetById(String uri) throws RuntimeException {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<BeneficiarioDTO> result = restTemplate.getForEntity(uri, BeneficiarioDTO.class);
            return result;
    }

}

