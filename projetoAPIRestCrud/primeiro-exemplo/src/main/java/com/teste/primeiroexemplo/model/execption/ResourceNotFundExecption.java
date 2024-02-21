package com.teste.primeiroexemplo.model.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFundExecption extends RuntimeException {

    public ResourceNotFundExecption(String mensagem){
         super(mensagem);
    }
}