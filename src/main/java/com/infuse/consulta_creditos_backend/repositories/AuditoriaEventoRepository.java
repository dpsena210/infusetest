package com.infuse.consulta_creditos_backend.repositories;

import com.infuse.consulta_creditos_backend.models.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaEventoRepository extends JpaRepository<Audit, Long> {
}
