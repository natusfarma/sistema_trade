package com.pc.natusfarma.trademkt.api.model;

import com.pc.natusfarma.trademkt.api.model.input.ClienteIdInput;
import com.pc.natusfarma.trademkt.domain.model.Anexo;

import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

public class TarefaModel {

    private Long id;
    private String descricao;
    private String titulo;
    private OffsetDateTime dataTarefa;
    private OffsetTime horaLimite;
    private SubcategoriaModel subcategoria;
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

    public OffsetDateTime getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(OffsetDateTime dataTarefa) {
        this.dataTarefa = dataTarefa;
    }

    public OffsetTime getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(OffsetTime horaLimite) {
        this.horaLimite = horaLimite;
    }

    public SubcategoriaModel getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubcategoriaModel subcategoria) {
        this.subcategoria = subcategoria;
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
