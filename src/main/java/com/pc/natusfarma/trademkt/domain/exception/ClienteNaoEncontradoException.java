package com.pc.natusfarma.trademkt.domain.exception;


public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long servialVersionUID = 1L;
    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ClienteNaoEncontradoException(Long id){
        this(String.format(
                "Não existe um cadastro de cliente com o código %d",id));
    }

}
