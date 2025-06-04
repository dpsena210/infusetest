package com.infuse.consulta_creditos_backend;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infuse.consulta_creditos_backend.kafka.consumer.AuditoriaKafkaConsumer;
import com.infuse.consulta_creditos_backend.repositories.AuditoriaEventoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

class AuditoriaKafkaConsumerTest {

    @Mock
    private AuditoriaEventoRepository repository;

    @InjectMocks
    private AuditoriaKafkaConsumer consumer;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapper = new ObjectMapper();
    }

    @Test
    void testConsumirEventoValido() throws JsonProcessingException {
        // Given
        String mensagemKafka = """
        {
            "numeroCredito": ["123", "456", "789"],
            "numeroNfse": "NFSE-9876",
            "acao": "CRIACAO",
            "timestamp": "2024-06-01T15:30:00"
        }
        """;

        // When / Then: apenas verificar que o método não lança exceção
        assertDoesNotThrow(() -> consumer.consumirEvento(mensagemKafka));
    }

    @Test
    void testConsumirEventoComListaVazia() throws JsonProcessingException {
        String mensagemKafka = """
        {
            "numeroCredito": [],
            "numeroNfse": "NFSE-0001",
            "acao": "ATUALIZACAO",
            "timestamp": "2024-06-01T10:00:00"
        }
        """;

        assertDoesNotThrow(() -> consumer.consumirEvento(mensagemKafka));
    }

    @Test
    void testConsumirEventoComFormatoInvalido() {
        String mensagemInvalida = """
        {
            "numeroCredito": ["123", "456"],
            "numeroNfse": "NFSE-0001"
            // Faltando "acao" e "timestamp"
        }
        """;

        assertThrows(JsonProcessingException.class, () -> consumer.consumirEvento(mensagemInvalida));
    }
}
