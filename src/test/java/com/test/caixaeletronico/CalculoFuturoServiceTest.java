package com.test.caixaeletronico;

import com.test.caixaeletronico.model.BeneficiarioDTO;
import com.test.caixaeletronico.resthttp.RestRequestBeneficiarioImpl;
import com.test.caixaeletronico.service.CalculoFuturoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CalculoFuturoServiceTest {

    @Mock
    private RestRequestBeneficiarioImpl restRequest;

    @InjectMocks
    private CalculoFuturoServiceImpl calculoFuturoService;

    @Test
    void shouldReturnCalculoOk(){
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO(1l, 1234l, "1234@124.com", new BigDecimal(200000), 8);
        BigDecimal valor = calculoFuturoService.calculaValorReceber(beneficiarioDTO, new BigDecimal(10000));
        System.out.print(valor);
        assertThat(valor).isEqualByComparingTo(new BigDecimal(2187.5));
    }

    @Test
    void shouldReturnCalculoMathException(){
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO(1l, 1234l, "1234@124.com", new BigDecimal(200000), 0);

        assertThatThrownBy(() -> {
            calculoFuturoService.calculaValorReceber(beneficiarioDTO, new BigDecimal(10000));
        }).isInstanceOf(ArithmeticException.class);
    }




}
