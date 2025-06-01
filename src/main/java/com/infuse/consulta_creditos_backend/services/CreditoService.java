package com.infuse.consulta_creditos_backend.services;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import com.infuse.consulta_creditos_backend.kafka.producer.AuditoriaKafkaProducer;
import com.infuse.consulta_creditos_backend.mappers.CreditoMapper;
import com.infuse.consulta_creditos_backend.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.infuse.consulta_creditos_backend.models.Credito;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    @Autowired
    CreditoRepository creditoRepository;

    @Autowired
    AuditoriaKafkaProducer auditoriaKafkaProducer;
    
    public void produceCreditosByNfse(String numeroCredito, String numeroNfse){
        auditoriaKafkaProducer.enviarEvento(

                new AuditoriaEvent(numeroCredito, numeroNfse,"get creditos by nfse", LocalDateTime.now())
        );
    }

    public void produceCreditoByNumber(String numeroCredito, String numeroNfse){
        auditoriaKafkaProducer.enviarEvento(
                new AuditoriaEvent(numeroCredito, numeroNfse,"get credito by number", LocalDateTime.now())
        );
    }
    
    public List<CreditoDto> getCreditoByNfse(String nfse){
        List<Credito> listCreditos = creditoRepository.findByNumeroNfse(nfse);
        CreditoMapper creditoMapper = new CreditoMapper();
        List<CreditoDto> listCreditoDto = creditoMapper.toCreditoDtoList(listCreditos);
        CreditoDto creditoDto = listCreditoDto.getFirst();
        String numeroCredito = creditoDto.getNumeroCredito();
        String numeroNtse = creditoDto.getNfse();
        produceCreditosByNfse(numeroCredito,numeroNtse);

        return  listCreditoDto;

    }

    public CreditoDto getCreditoByNumero(String numeroCredito){
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito);
        CreditoMapper creditoMapper = new CreditoMapper();
        CreditoDto creditoDto = creditoMapper.toCreditoDto(credito);
        String numeroNtse = creditoDto.getNfse();
        produceCreditoByNumber(numeroCredito,numeroNtse);

        return creditoDto;
    }
}
