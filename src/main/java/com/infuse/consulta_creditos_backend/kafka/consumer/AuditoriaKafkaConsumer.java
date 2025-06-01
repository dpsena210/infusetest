package com.infuse.consulta_creditos_backend.kafka.consumer;

import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import com.infuse.consulta_creditos_backend.repositories.AuditoriaEventoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditoriaKafkaConsumer {

    private final AuditoriaEventoRepository repository;

    public AuditoriaKafkaConsumer(AuditoriaEventoRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "auditoria-topic", groupId = "grupo-auditoria")
    public void consumirEvento(String mensagem) {
        // Cria entidade e salva no banco
        AuditoriaEvent evento = new AuditoriaEvent();
        evento.setEvento(mensagem);
        evento.setDataHora(LocalDateTime.now());

        repository.save(evento);

        System.out.println("Evento salvo no banco: " + mensagem);
    }
}
