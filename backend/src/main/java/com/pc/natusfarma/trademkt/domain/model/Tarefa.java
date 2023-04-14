package com.pc.natusfarma.trademkt.domain.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarefa_id")
    private Long id;
    @Column(name = "tarefa_descricao")
    private String descricao;
    @Column(name = "tarefa_titulo")
    private String titulo;
    @Column(name = "tarefa_dataTarefa")
    private LocalDate dataTarefa;
    @Column(name = "tarefa_horalimite")
    private LocalTime horaLimite;
    @CreationTimestamp
    @Column(name = "tarefa_datacadastro", nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;
    @ManyToOne
    @JoinColumn(name = "subcategoria_id", nullable = false)
    private Subcategoria subcategoria;
    @ManyToMany
    @JoinTable(name = "tarefa_anexo",
            joinColumns = @JoinColumn(name = "tarefa_id") ,
            inverseJoinColumns = @JoinColumn(name = "anexo_id"))
    private List<Anexo> anexos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(LocalDate dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public LocalTime getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(LocalTime horaLimite) {
        this.horaLimite = horaLimite;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", titulo='" + titulo + '\'' +
                ", dataTarefa=" + dataTarefa +
                ", horaLimite=" + horaLimite +
                ", dataCadastro=" + dataCadastro +
                ", subcategoria=" + subcategoria +
                ", anexos=" + anexos +
                '}';
    }
}
