package com.pc.natusfarma.trademkt.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubcategoriaNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;
    public SubcategoriaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public SubcategoriaNaoEncontradaException(Long id){
        this(String.format("Não existe um cadastro de subcategoria com o código %d",id));
    }
}
