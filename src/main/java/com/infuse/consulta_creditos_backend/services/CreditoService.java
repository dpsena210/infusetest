package com.infuse.consulta_creditos_backend.services;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.mappers.CreditoMapper;
import com.infuse.consulta_creditos_backend.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.infuse.consulta_creditos_backend.models.Credito;

import java.util.List;
import java.util.Optional;

public class CreditoService {

    @Autowired
    CreditoRepository creditoRepository;
    
    
    
    public List<CreditoDto> getCreditoByNfse(String nfse){
        List<Credito> listCreditos = creditoRepository.findByNumeroNfse(nfse);

        CreditoMapper creditoMapper = new CreditoMapper();
        return  creditoMapper.toCreditoDtoList(listCreditos);

    }
}
