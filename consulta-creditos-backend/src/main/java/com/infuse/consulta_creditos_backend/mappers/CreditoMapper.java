package com.infuse.consulta_creditos_backend.mappers;

import com.infuse.consulta_creditos_backend.dtos.CreditoDto;
import com.infuse.consulta_creditos_backend.models.Credito;
import org.apache.catalina.User;

import java.util.stream.Collectors;

import java.util.List;


public class CreditoMapper {

    public CreditoDto toCreditoDto(Credito credito){
        return CreditoDto.builder()
                .numeroCredito(credito.getNumeroCredito())
                .nfse(credito.getNumeroNfse())
                .dataConstituicao(credito.getDataConstituicao())
                .valorIssqn(credito.getValorIssqn())
                .tipoCredito(credito.getTipoCredito())
                .simplesNacional(credito.isSimplesNacional())
                .aliquota(credito.getAliquota())
                .valorFaturado(credito.getValorFaturado())
                .valorDeducao(credito.getValorDeducao())
                .baseCalculo(credito.getBaseCalculo())
                .build();
    }
    public List<CreditoDto> toCreditoDtoList(List<Credito> creditoList){
        return creditoList.stream()
        .map(this::toCreditoDto)
                .collect(Collectors.toList());
    }

}
