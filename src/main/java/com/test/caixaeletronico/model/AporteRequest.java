package com.test.caixaeletronico.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import java.math.BigDecimal;

public class AporteRequest {
    @JsonProperty("id_beneficiario")
    private Long idBeneficiario;
    @JsonProperty("valor_aporte")
    private BigDecimal valorAporte;

    public AporteRequest(){

    }

    public AporteRequest(Long idBeneficiario, BigDecimal valorAporte) {
        this.idBeneficiario = idBeneficiario;
        this.valorAporte = valorAporte;
    }

    public Long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public BigDecimal getValorAporte() {
        return valorAporte;
    }

    public void setValorAporte(BigDecimal valorAporte) {
        this.valorAporte = valorAporte;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
