package com.test.caixaeletronico.controller;

import com.test.caixaeletronico.model.AporteRequest;
import com.test.caixaeletronico.model.BeneficiarioDTO;
import com.test.caixaeletronico.queue.AporteSender;
import com.test.caixaeletronico.service.CalculoFuturoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/aporte")
public class AporteController {

    @Autowired
    CalculoFuturoService calculoFuturoService;

    @PostMapping
    public ResponseEntity<String> sendAporte(@RequestBody AporteRequest aporteRequest){
        BeneficiarioDTO beneficiarioDTO = calculoFuturoService.processaAporte(aporteRequest);
        return ResponseEntity.ok("O valor a receber na aposentadoria é "+calculoFuturoService.calculaValorReceber(beneficiarioDTO, aporteRequest.getValorAporte()));
    }
}
