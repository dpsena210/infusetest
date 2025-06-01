package com.infuse.consulta_creditos_backend.kafka.producer;

import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaKafkaProducer {

    private static final String TOPIC = "auditoria-creditos";

    @Autowired
    private KafkaTemplate<String, AuditoriaEvent> kafkaTemplate;

    public void enviarEvento(AuditoriaEvent evento) {
        kafkaTemplate.send(TOPIC, evento);
    }
}
