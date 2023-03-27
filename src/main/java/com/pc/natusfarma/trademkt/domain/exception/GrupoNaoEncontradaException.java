package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GrupoNaoEncontradaException extends  EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public GrupoNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public GrupoNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de grupo com o código %d",id));
    }
}
