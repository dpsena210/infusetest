package com.infuse.consulta_creditos_backend.controllers;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.kafka.event.AuditoriaEvent;
import com.infuse.consulta_creditos_backend.kafka.producer.AuditoriaKafkaProducer;
import com.infuse.consulta_creditos_backend.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
@RequestMapping
public class ConsultaController {

    @Autowired
    private CreditoService creditoService;


    @Autowired
    private AuditoriaKafkaProducer auditoriaKafkaProducer;


    @GetMapping("/api/creditos/{numeroNfse}")
    public List<CreditoDto> getCreditos(@PathVariable String numeroNfse){
        auditoriaKafkaProducer.enviarEvento(
                new AuditoriaEvent("/api/creditos/" + numeroNfse, numeroNfse, LocalDateTime.now())
        );
        return creditoService.getCreditoByNfse(numeroNfse);
    }

    @GetMapping("/api/credito/{numeroCredito}")
    public CreditoDto getCredito(@PathVariable String numeroCredito){
        auditoriaKafkaProducer.enviarEvento(
                new AuditoriaEvent("/api/creditos/credito/" + numeroCredito, numeroCredito, LocalDateTime.now())
        );
        return creditoService.getCreditoByNumero(numeroCredito);
    }
}
