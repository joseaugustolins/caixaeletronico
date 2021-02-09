package com.test.caixaeletronico.service;

import com.test.caixaeletronico.model.AporteRequest;
import com.test.caixaeletronico.model.BeneficiarioDTO;
import com.test.caixaeletronico.queue.AporteSender;
import com.test.caixaeletronico.resthttp.RestRequestBeneficiario;
import com.test.caixaeletronico.resthttp.exception.BeneficiarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculoFuturoServiceImpl implements  CalculoFuturoService{
    @Autowired
    AporteSender aporteSender;
    @Autowired
    RestRequestBeneficiario restRequest;

    @Override
    public BeneficiarioDTO processaAporte(AporteRequest aporteRequest){
        validate(aporteRequest);
        final String uri = "http://localhost:8080/beneficiario/aportar/"+aporteRequest.getIdBeneficiario();
        HttpEntity<BigDecimal> requestUpdate = new HttpEntity<>(aporteRequest.getValorAporte());
        ResponseEntity<BeneficiarioDTO> beneficiarioDTOResponseEntity = restRequest.requestPut(uri, requestUpdate);
        aporteSender.send(aporteRequest.toJson());
        return beneficiarioDTOResponseEntity.getBody();
    }

    @Override
    public void validate(AporteRequest aporteRequest){
        final String uri = "http://localhost:8080/beneficiario/"+aporteRequest.getIdBeneficiario();
        try {
            restRequest.requestGetById(uri);
        }catch (BeneficiarioNotFoundException ex){
            throw new BeneficiarioNotFoundException(ex.getMessage());
        }
    }

    @Override
    public BigDecimal calculaValorReceber(BeneficiarioDTO beneficiarioDTO, BigDecimal valorAporte){
        BigDecimal valorTotal = beneficiarioDTO.getValor().add(valorAporte);
        return valorTotal.divide(new BigDecimal(beneficiarioDTO.getAnos()*12), 2, RoundingMode.HALF_UP);
    }

}
