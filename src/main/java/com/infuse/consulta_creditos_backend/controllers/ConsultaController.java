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
    CreditoService creditoService;


    @GetMapping("/api/creditos/{numeroNfse}")
    public List<CreditoDto> getCreditos(@PathVariable String numeroNfse){
        return creditoService.getCreditosByNfse(numeroNfse);
    }

    @GetMapping("/api/credito/{numeroCredito}")
    public CreditoDto getCredito(@PathVariable String numeroCredito){

        return creditoService.getCreditoByNumero(numeroCredito);
    }
}
