package com.infuse.consulta_creditos_backend.kafka.consumer;

import com.infuse.consulta_creditos_backend.models.Audit;
import com.infuse.consulta_creditos_backend.repositories.AuditoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AuditoriaKafkaConsumer {

    @Autowired
    AuditoriaEventoRepository repository;


    @KafkaListener(topics = "auditoria-topic", groupId = "grupo-auditoria")
    public void consumirEvento(String numeroCredito, String numeroNfse, String acao, LocalDateTime timestamp) {
        Audit evento = new Audit(numeroCredito,numeroNfse,acao,timestamp);
        repository.save(evento);


    }
}
