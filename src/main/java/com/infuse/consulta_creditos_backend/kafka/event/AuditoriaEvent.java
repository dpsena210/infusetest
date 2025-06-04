package com.infuse.consulta_creditos_backend.kafka.event;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AuditoriaEvent {

    private List<String> numeroCredito;

    private String numeroNfse;

    private String acao;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public AuditoriaEvent(List<String> numeroCredito, String numeroNfse, String acao, LocalDateTime timestamp) {
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.acao = acao;
        this.timestamp = timestamp;
    }


}
