package com.infuse.consulta_creditos_backend;

import com.infuse.consulta_creditos_backend.models.Audit;
import com.infuse.consulta_creditos_backend.repositories.AuditoriaEventoRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class AuditoriaEventoRepositoryTest {

    @Autowired
    private AuditoriaEventoRepository auditoriaEventoRepository;

    @Test
    public void deveSalvarEEncontrarAudit() {
        Audit audit = new Audit(
                Arrays.asList("12345", "67890"),
                "NFSE123456",
                "CRIACAO",
                LocalDateTime.now()
        );

        Audit salvo = auditoriaEventoRepository.save(audit);
        assertThat(salvo.getId()).isNotNull();

        Audit encontrado = auditoriaEventoRepository.findById(salvo.getId()).orElse(null);
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getNumeroNfse()).isEqualTo("NFSE123456");
        assertThat(encontrado.getAcao()).isEqualTo("CRIACAO");
        assertThat(encontrado.getNumeroCredito()).containsExactly("12345", "67890");
        assertThat(encontrado.getTimestamp()).isNotNull();
    }
}
