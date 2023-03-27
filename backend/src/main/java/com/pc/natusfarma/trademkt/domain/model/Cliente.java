package com.pc.natusfarma.trademkt.domain.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;
    @Column(name = "cliente_nome", nullable = false)
    private String nome;
    @Column(name = "cliente_status", nullable = false)
    private String status;
    @Column(name = "cliente_senha")
    private String senha;

    @Column(name = "cliente_email", nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name = "cliente_datacadastro", nullable = false  ,columnDefinition = "datetime")
    private OffsetDateTime dataCadastro;
    @ManyToOne
    @JoinColumn(name = "perfil_id",nullable = true)
    private Perfil perfil;

    @ManyToMany
    @JoinTable(name = "cliente_grupo",
            joinColumns = @JoinColumn(name = "cliente_id") ,
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", perfil=" + perfil +
                ", grupos=" + grupos +
                '}';
    }
}
