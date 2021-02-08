package com.test.caixaeletronico.service;

import com.test.caixaeletronico.model.AporteRequest;
import com.test.caixaeletronico.model.BeneficiarioDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CalculoFuturoService {
    public BeneficiarioDTO processaAporte(AporteRequest aporteRequest);
    public BigDecimal calculaValorReceber(BeneficiarioDTO beneficiarioDTO, BigDecimal valorAporte);
    public void validate(AporteRequest aporteRequest);
}
