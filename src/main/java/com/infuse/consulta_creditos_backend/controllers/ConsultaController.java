package com.infuse.consulta_creditos_backend.controllers;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.services.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping
public class ConsultaController {

    @Autowired
    CreditoService creditoService;


    @GetMapping("/api/creditos")
    @CrossOrigin(origins = "http://localhost:80")
    public List<CreditoDto> getAllCreditos(){
        return creditoService.getCreditosAll();
    }

    @GetMapping("/api/creditos/{numeroNfse}")
    @CrossOrigin(origins = "http://localhost:80")
    public List<CreditoDto> getCreditos(@PathVariable String numeroNfse){
        return creditoService.getCreditosByNfse(numeroNfse.toUpperCase());
    }

    @GetMapping("/api/credito/{numeroCredito}")
    @CrossOrigin(origins = "http://localhost:80")
    public CreditoDto getCredito(@PathVariable String numeroCredito){
        return creditoService.getCreditoByNumero(numeroCredito.toUpperCase());
    }
}
