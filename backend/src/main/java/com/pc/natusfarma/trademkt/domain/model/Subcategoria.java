package com.pc.natusfarma.trademkt.domain.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "subcategoria")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategoria_id")
    private Long Id;

    @Column(name = "subcategoria_descricao", nullable = false)
    private String descricao;
    @CreationTimestamp
    @Column(name =  "subcategoria_datacadastro", nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Subcategoria{" +
                "Id=" + Id +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", categoria=" + categoria +
                '}';
    }
}
