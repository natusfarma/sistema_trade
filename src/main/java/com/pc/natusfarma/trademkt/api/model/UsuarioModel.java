package com.pc.natusfarma.trademkt.api.model;

import com.pc.natusfarma.trademkt.domain.model.Grupo;
import com.pc.natusfarma.trademkt.domain.model.Perfil;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {

    private Long id;
    private String nome;
    private String status;
    private String senha;
    private OffsetDateTime dataCadastro;
    private Perfil perfil;
    private List<Grupo> grupos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
