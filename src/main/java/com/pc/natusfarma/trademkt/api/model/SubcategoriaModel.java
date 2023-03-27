package com.pc.natusfarma.trademkt.api.model;

import com.pc.natusfarma.trademkt.domain.model.Categoria;


public class SubcategoriaModel {

    private Long Id;
    private String descricao;
    private CategoriaModel categoria;

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

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
