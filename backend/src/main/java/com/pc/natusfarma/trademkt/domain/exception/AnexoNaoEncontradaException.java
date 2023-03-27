package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnexoNaoEncontradaException extends  EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public AnexoNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public AnexoNaoEncontradaException(Long id) {
        this(String.format("Não existe um anexo com o código %d",id));
    }
}
