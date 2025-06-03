package com.infuse.consulta_creditos_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "audit")
@Data
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @Column(name = "numero_credito")
    private List<String> numeroCredito;

    @Column
    private String numeroNfse;

    @Column
    private String acao;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Audit() {}

    public Audit(List<String> numeroCredito, String numeroNfse, String acao, LocalDateTime timestamp) {
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.acao = acao;
        this.timestamp = timestamp;
    }
}
