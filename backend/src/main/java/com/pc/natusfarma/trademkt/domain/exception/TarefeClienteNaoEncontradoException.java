package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TarefeClienteNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public TarefeClienteNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public TarefeClienteNaoEncontradoException(Long tarefaId, Long clienteId) {
        this(String.format("Não existe a tarefa de código %d e o código do cliente %d ",tarefaId, clienteId));
    }

    public TarefeClienteNaoEncontradoException(Long id) {
        this(String.format("Não existe uma terefa e cliente com o código %d",id));
    }
}
