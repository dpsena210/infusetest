package com.infuse.consulta_creditos_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit")
@Data
public class Audit {

        @Id
        @GeneratedValue
        private Long id;

        @Column
        private String numeroCredito;

        @Column
        private String numeroNfse;

        @Column
        private String acao;

        @Column
        private LocalDateTime timestamp;

        public Audit(String numeroCredito, String numeroNfse, String acao, LocalDateTime timestamp){
            this.numeroCredito = numeroCredito;
            this.numeroNfse = numeroNfse;
            this.acao = acao;
            this.timestamp = timestamp;
        }
}
