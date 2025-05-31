package com.infuse.consulta_creditos_backend.repositories;

import com.infuse.consulta_creditos_backend.models.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditoRepository extends JpaRepository<Credito,Long> {
    List<Credito> findByNumeroNfse(String nfse);
}
