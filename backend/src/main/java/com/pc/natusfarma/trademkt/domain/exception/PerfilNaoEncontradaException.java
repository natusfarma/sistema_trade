package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PerfilNaoEncontradaException extends  EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public PerfilNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public PerfilNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de perfil com o código %d",id));
    }
}
