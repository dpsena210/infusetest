package com.infuse.consulta_creditos_backend;
import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.mappers.CreditoMapper;
import com.infuse.consulta_creditos_backend.models.Credito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CreditoMapperTest {

    private CreditoMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new CreditoMapper();
    }

    @Test
    void testToCreditoDto() {
        Credito credito = new Credito();
        credito.setNumeroCredito("12345");
        credito.setNumeroNfse("NFSE-001");
        credito.setDataConstituicao(LocalDate.of(2023, 12, 1));
        credito.setValorIssqn(new BigDecimal("150.00"));
        credito.setTipoCredito("Tipo A");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal("0.05"));
        credito.setValorFaturado(new BigDecimal("1000.00"));
        credito.setValorDeducao(new BigDecimal("50.00"));
        credito.setBaseCalculo(new BigDecimal("950.00"));

        CreditoDto dto = mapper.toCreditoDto(credito);

        assertNotNull(dto);
        assertEquals("12345", dto.getNumeroCredito());
        assertEquals("NFSE-001", dto.getNfse());
        assertEquals(LocalDate.of(2023, 12, 1), dto.getDataConstituicao());
        assertEquals(new BigDecimal("150.00"), dto.getValorIssqn());
        assertEquals("Tipo A", dto.getTipoCredito());
        assertTrue(dto.getSimplesNacional());
        assertEquals(new BigDecimal("0.05"), dto.getAliquota());
        assertEquals(new BigDecimal("1000.00"), dto.getValorFaturado());
        assertEquals(new BigDecimal("50.00"), dto.getValorDeducao());
        assertEquals(new BigDecimal("950.00"), dto.getBaseCalculo());
    }

    @Test
    void testToCreditoDtoList() {
        Credito credito1 = new Credito();
        credito1.setNumeroCredito("12345");
        credito1.setNumeroNfse("NFSE-001");
        credito1.setDataConstituicao(LocalDate.of(2023, 12, 1));
        credito1.setValorIssqn(new BigDecimal("150.00"));
        credito1.setTipoCredito("Tipo A");
        credito1.setSimplesNacional(true);
        credito1.setAliquota(new BigDecimal("0.05"));
        credito1.setValorFaturado(new BigDecimal("1000.00"));
        credito1.setValorDeducao(new BigDecimal("50.00"));
        credito1.setBaseCalculo(new BigDecimal("950.00"));

        Credito credito2 = new Credito();
        credito2.setNumeroCredito("67890");
        credito2.setNumeroNfse("NFSE-002");
        credito2.setDataConstituicao(LocalDate.of(2024, 1, 15));
        credito2.setValorIssqn(new BigDecimal("200.00"));
        credito2.setTipoCredito("Tipo B");
        credito2.setSimplesNacional(false);
        credito2.setAliquota(new BigDecimal("0.07"));
        credito2.setValorFaturado(new BigDecimal("2000.00"));
        credito2.setValorDeducao(new BigDecimal("100.00"));
        credito2.setBaseCalculo(new BigDecimal("1900.00"));

        List<CreditoDto> dtoList = mapper.toCreditoDtoList(List.of(credito1, credito2));

        assertNotNull(dtoList);
        assertEquals(2, dtoList.size());

        CreditoDto dto1 = dtoList.get(0);
        assertEquals("12345", dto1.getNumeroCredito());
        assertEquals("NFSE-001", dto1.getNfse());

        CreditoDto dto2 = dtoList.get(1);
        assertEquals("67890", dto2.getNumeroCredito());
        assertEquals("NFSE-002", dto2.getNfse());
    }
}
