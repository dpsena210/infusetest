package com.infuse.consulta_creditos_backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditoDto {

    private String numeroCredito;

    private String nfse;

    public LocalDate dataConstituicao;

    public BigDecimal valorIssqn;

    public String tipoCredito;

    public Boolean simplesNacional;

    public BigDecimal aliquota;

    public BigDecimal valorFaturado;

    public BigDecimal valorDeducao;

    public BigDecimal baseCalculo;

}
