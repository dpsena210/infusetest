package com.infuse.consulta_creditos_backend.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import com.infuse.consulta_creditos_backend.models.Audit;
import com.infuse.consulta_creditos_backend.repositories.AuditoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriaKafkaConsumer {

    @Autowired
    AuditoriaEventoRepository repository;


    @KafkaListener(topics = "auditoria-creditos", groupId = "grupo-auditoria")
    public void consumirEvento(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(message);

        JsonNode arrayNode =  node.get("numeroCredito");
        String numeroNfse = node.get("numeroNfse").asText();
        String acao = node.get("acao").asText();
        String timestamp = node.get("timestamp").asText();

        List<String> listaCreditos = new ArrayList<>();
        if (arrayNode.isArray()) {
            for (JsonNode elemento : arrayNode) {
                listaCreditos.add(elemento.asText());
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime timestampDate = LocalDateTime.parse(timestamp, formatter);

        System.out.println("lista créditos"+listaCreditos);

    }
}
