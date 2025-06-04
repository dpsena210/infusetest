package com.infuse.consulta_creditos_backend;
import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.exceptions.CreditosNaoEncontrados;
import com.infuse.consulta_creditos_backend.kafka.producer.AuditoriaKafkaProducer;
import com.infuse.consulta_creditos_backend.mappers.CreditoMapper;
import com.infuse.consulta_creditos_backend.models.Credito;
import com.infuse.consulta_creditos_backend.repositories.CreditoRepository;
import com.infuse.consulta_creditos_backend.services.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditoServiceTest {

    @InjectMocks
    private CreditoService creditoService;

    @Mock
    private CreditoRepository creditoRepository;

    @Mock
    private AuditoriaKafkaProducer auditoriaKafkaProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        creditoService.setCreditoMapper(new CreditoMapper());
    }

    @Test
    void deveRetornarTodosOsCreditos() {
        Credito credito = new Credito();
        credito.setNumeroCredito("123");
        credito.setNumeroNfse("ABC");

        when(creditoRepository.findAll()).thenReturn(List.of(credito));

        List<CreditoDto> result = creditoService.getCreditosAll();

        assertEquals(1, result.size());
        assertEquals("123", result.get(0).getNumeroCredito());
    }

    @Test
    void deveRetornarCreditosPorNfse() {
        Credito credito = new Credito();
        credito.setNumeroCredito("456");
        credito.setNumeroNfse("XYZ");

        when(creditoRepository.findByNumeroNfse("XYZ")).thenReturn(List.of(credito));

        List<CreditoDto> result = creditoService.getCreditosByNfse("XYZ");

        assertEquals(1, result.size());
        assertEquals("456", result.get(0).getNumeroCredito());
    }

    @Test
    void deveLancarExcecaoSeNaoEncontrarCreditosPorNfse() {
        when(creditoRepository.findByNumeroNfse("NAOEXISTE")).thenReturn(List.of());

        CreditosNaoEncontrados thrown = assertThrows(
                CreditosNaoEncontrados.class,
                () -> creditoService.getCreditosByNfse("NAOEXISTE")
        );

        assertTrue(thrown.getMessage().contains("NAOEXISTE"));
    }

    @Test
    void deveRetornarCreditoPorNumero() {
        Credito credito = new Credito();
        credito.setNumeroCredito("789");
        credito.setNumeroNfse("NF789");

        when(creditoRepository.findByNumeroCredito("789")).thenReturn(credito);

        CreditoDto result = creditoService.getCreditoByNumero("789");

        assertEquals("789", result.getNumeroCredito());
    }

    @Test
    void deveLancarExcecaoSeNaoEncontrarCreditoPorNumero() {
        when(creditoRepository.findByNumeroCredito("000")).thenReturn(null);

        assertThrows(CreditosNaoEncontrados.class,
                () -> creditoService.getCreditoByNumero("000"));
    }
}
