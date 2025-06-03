package com.infuse.consulta_creditos_backend;

import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import com.infuse.consulta_creditos_backend.kafka.producer.AuditoriaKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class AuditoriaKafkaProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private AuditoriaKafkaProducer producer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEnviarEvento() {

        // Given
        AuditoriaEvent evento = new AuditoriaEvent(java.util.List.of("123", "456"),"NFSE-001","CRIACAO", LocalDateTime.now());


        // When
        producer.enviarEvento(evento);

        // Then
        verify(kafkaTemplate, times(1)).send("auditoria-creditos", evento);
    }
}
