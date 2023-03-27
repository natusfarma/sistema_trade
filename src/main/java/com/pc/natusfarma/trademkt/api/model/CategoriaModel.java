package com.pc.natusfarma.trademkt.api.model;

import javax.persistence.Column;

public class CategoriaModel {

    private Long Id;
    private String descricao;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
