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
import java.util.stream.Collectors;

@Service
public class CreditoService {

    @Autowired
    CreditoRepository creditoRepository;

    @Autowired
    AuditoriaKafkaProducer auditoriaKafkaProducer;
    
    public void produceCreditosByNfse(List<String> numeroCredito, String numeroNfse){
        auditoriaKafkaProducer.enviarEvento(
                new AuditoriaEvent(numeroCredito, numeroNfse,"get creditos by nfse", LocalDateTime.now())
        );
    }

    public void produceCreditoByNumber(List<String> numeroCredito, String numeroNfse){
        auditoriaKafkaProducer.enviarEvento(
                new AuditoriaEvent(numeroCredito, numeroNfse,"get credito by number", LocalDateTime.now())
        );
    }
    
    public List<CreditoDto> getCreditosByNfse(String nfse){
        List<Credito> listCreditos = creditoRepository.findByNumeroNfse(nfse);
        CreditoMapper creditoMapper = new CreditoMapper();
        List<CreditoDto> listCreditoDto = creditoMapper.toCreditoDtoList(listCreditos);
        List<String> listNumerosCredito = listCreditoDto.stream().map(CreditoDto::getNumeroCredito)
                .collect(Collectors.toList());
        String numeroNtse = listCreditoDto.getFirst().getNfse();
        produceCreditosByNfse(listNumerosCredito,numeroNtse);

        return  listCreditoDto;

    }

    public CreditoDto getCreditoByNumero(String numeroCredito){

        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito);
        CreditoMapper creditoMapper = new CreditoMapper();
        CreditoDto creditoDto = creditoMapper.toCreditoDto(credito);
        String numeroNtse = creditoDto.getNfse();
        List<String> listNumeroCredito = numeroCredito.lines().toList();
        produceCreditoByNumber(listNumeroCredito,numeroNtse);

        return creditoDto;
    }
}
