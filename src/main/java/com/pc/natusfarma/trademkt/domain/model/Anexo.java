package com.pc.natusfarma.trademkt.domain.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Arrays;

@Entity
@Table(name = "anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anexo_id")
    private Long id;
    @Column(name = "anexo_documento")
    private byte[] documento;

    @Column(name = "anexo_dataCadastro")
    private OffsetDateTime dataCadastro;

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

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
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
