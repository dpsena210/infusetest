package com.infuse.consulta_creditos_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="credito")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numeroCredito;

    @Column
    private String numeroNfse;

    @Column
    private LocalDate dataConstituicao;

    @Column
    private BigDecimal valorIssqn;

    @Column
    private String tipoCredito;

    @Column
    private boolean simplesNacional;

    @Column
    private BigDecimal aliquota;

    @Column
    private BigDecimal valorFaturado;

    @Column
    private BigDecimal valorDeducao;

    @Column
    private BigDecimal baseCalculo;

}
