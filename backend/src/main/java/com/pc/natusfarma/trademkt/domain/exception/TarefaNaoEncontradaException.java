package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TarefaNaoEncontradaException extends EntidadeNaoEncontradaException {

    public TarefaNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public TarefaNaoEncontradaException(Long id) {
        this(String.format("Não existe uma tarefa cadastrada com o código %d",id));
    }
}
