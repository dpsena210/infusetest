package com.infuse.consulta_creditos_backend.exceptions;

public class CreditosNaoEncontrados extends RuntimeException{
    public CreditosNaoEncontrados(String message){
        super(message);
    }
}
