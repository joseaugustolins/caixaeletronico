package com.test.caixaeletronico.model;


import java.math.BigDecimal;

public class BeneficiarioDTO {
    private Long id;
    private Long cpf;
    private String email;
    private BigDecimal valor;
    private Integer anos;

    public BeneficiarioDTO(){

    }

    public BeneficiarioDTO(Long id, Long cpf, String email, BigDecimal valor, Integer anos) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.anos = anos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos;
    }

}

