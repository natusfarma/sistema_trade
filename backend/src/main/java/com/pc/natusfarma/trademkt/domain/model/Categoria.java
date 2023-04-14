package com.pc.natusfarma.trademkt.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long Id;
    @Column(name = "categoria_descricao")
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Subcategoria> subcategorias = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "categoria_datacadastro", nullable = false, columnDefinition = "datetime", updatable = false)
    private LocalDateTime dataCadastro;

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

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Id=" + Id +
                ", descricao='" + descricao + '\'' +
                ", subcategorias=" + subcategorias +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
