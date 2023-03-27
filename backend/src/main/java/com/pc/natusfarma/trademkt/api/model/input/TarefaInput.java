package com.pc.natusfarma.trademkt.api.model.input;

import com.pc.natusfarma.trademkt.domain.model.Anexo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

public class TarefaInput {

    private Long id;
    private String descricao;
    private String titulo;
    private LocalDate dataTarefa;
    private LocalTime horaLimite;
    private SubcategoriaIdInput subcategoriaId;
    private List<Anexo> anexos = new ArrayList<>();
    private List<ClienteIdInput> clientes = new ArrayList<>();

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

    public SubcategoriaIdInput getSubcategoriaId() {
        return subcategoriaId;
    }

    public void setSubcategoriaId(SubcategoriaIdInput subcategoriaId) {
        this.subcategoriaId = subcategoriaId;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    public List<ClienteIdInput> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteIdInput> clientes) {
        this.clientes = clientes;
    }
}
