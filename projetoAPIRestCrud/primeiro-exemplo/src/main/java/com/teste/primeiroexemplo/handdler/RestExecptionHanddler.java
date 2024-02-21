package com.teste.primeiroexemplo.handdler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiroexemplo.model.error.ErrorMenseger;
import com.teste.primeiroexemplo.model.execption.ResourceNotFundExecption;

@ControllerAdvice
public class RestExecptionHanddler {

    @ExceptionHandler
    public ResponseEntity<?> handdlerResourceNotFoundExecption(ResourceNotFundExecption ex) {
        ErrorMenseger error = new ErrorMenseger("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
