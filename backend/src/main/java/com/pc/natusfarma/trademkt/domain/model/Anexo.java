package com.pc.natusfarma.trademkt.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anexo_id")
    private Long id;

    //@JsonIgnore
    @Lob
    @Column(name = "anexo_documento")
    private byte[] documento;

    @CreationTimestamp
    @Column(name = "anexo_dataCadastro", columnDefinition = "datetime", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "anexo_extensao")
    private String extensao;

    @Column(name = "anexo_nome")
    private String nome;

    @Column(name = "anexo_tamanho")
    private long tamanho;

    @PrePersist
    public void prePersist(){
        this.setNome(UUID.randomUUID().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Anexo{" +
                "id=" + id +
                ", documento=" + Arrays.toString(documento) +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
