package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class EntidadeNaoEncontradaException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
