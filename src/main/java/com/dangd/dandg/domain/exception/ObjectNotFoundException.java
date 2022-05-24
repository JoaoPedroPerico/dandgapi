package com.dangd.dandg.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ObjectNotFoundException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
