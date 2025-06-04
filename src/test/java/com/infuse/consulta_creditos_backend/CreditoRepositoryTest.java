package com.infuse.consulta_creditos_backend;
import com.infuse.consulta_creditos_backend.models.Credito;
import com.infuse.consulta_creditos_backend.repositories.CreditoRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CreditoRepositoryTest {

    @Autowired
    private CreditoRepository creditoRepository;

    @Test
    public void deveSalvarEBuscarCreditoPorNumeroCredito() {
        Credito credito = Credito.builder()
                .numeroCredito("CRED123")
                .numeroNfse("NFSE456")
                .dataConstituicao(LocalDate.of(2024, 6, 3))
                .valorIssqn(new BigDecimal("100.00"))
                .tipoCredito("TipoA")
                .simplesNacional(true)
                .aliquota(new BigDecimal("2.5"))
                .valorFaturado(new BigDecimal("200.00"))
                .valorDeducao(new BigDecimal("20.00"))
                .baseCalculo(new BigDecimal("180.00"))
                .build();

        // Salva o crédito
        Credito salvo = creditoRepository.save(credito);
        assertThat(salvo.getId()).isNotNull();

        // Busca por numeroCredito
        Credito encontrado = creditoRepository.findByNumeroCredito("CRED123");
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getNumeroCredito()).isEqualTo("CRED123");

        // Busca por numeroNfse
        List<Credito> listaPorNfse = creditoRepository.findByNumeroNfse("NFSE456");
        assertThat(listaPorNfse).isNotEmpty();
        assertThat(listaPorNfse.get(0).getNumeroNfse()).isEqualTo("NFSE456");
    }
}
