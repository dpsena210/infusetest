package com.infuse.consulta_creditos_backend.kafka.event;

import java.time.LocalDateTime;

public class AuditoriaEvent {

    private String numeroCredito;
    private String numeroNfse;
    private String acao;

    private LocalDateTime timestamp;

    public AuditoriaEvent(String numeroCredito, String numeroNfse, String acao, LocalDateTime timestamp) {
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.acao = acao;
        this.timestamp = timestamp;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public String getAcao() {
        return acao;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


}
