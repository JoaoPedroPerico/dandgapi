package com.dangd.dandg.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;
import java.util.Set;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    //EmptyResultDataAccessException >> Ao tentar excluir index inválido
    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity errorNotFound(Exception exception) {
        return ResponseEntity.notFound().build();
    }

    //IllegalArgumentException >> Passando ID no POST
    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity errorBadRequest(Exception exception) {
        return ResponseEntity.badRequest().build();
    }

    //Sobrescrevendo o metodo do ResponseEntityExceptionHandler que retorna toda a trace quando endpoint é usado errado
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new MensagemException("Operação não permitida no endpoint"), HttpStatus.METHOD_NOT_ALLOWED);
    }
}

class MensagemException implements Serializable {
    public String erro;

    MensagemException(String erro){
        this.erro = erro;
    }
}

