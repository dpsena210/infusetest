package com.infuse.consulta_creditos_backend.kafka.event;

import java.time.LocalDateTime;

public class AuditoriaEvent {

    private String numeroCredito;
    private String acao;
    private LocalDateTime timestamp;

    public AuditoriaEvent(String numeroCredito, String acao, LocalDateTime timestamp) {
        this.numeroCredito = numeroCredito;
        this.acao = acao;
        this.timestamp = timestamp;
    }


}
