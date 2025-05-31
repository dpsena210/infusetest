package com.infuse.consulta_creditos_backend.controllers;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping
public class ConsultaController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping("/api/creditos/{numeroNfse}")
    public List<CreditoDto> getCreditos(){
        return creditoService.getCreditoByNfse(numeroNfse);
    }
}
