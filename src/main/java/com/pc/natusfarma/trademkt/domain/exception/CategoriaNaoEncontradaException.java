package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaNaoEncontradaException extends  EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public CategoriaNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de categoria com o código %d",id));
    }
}
