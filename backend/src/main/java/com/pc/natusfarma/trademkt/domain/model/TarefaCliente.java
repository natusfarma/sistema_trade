package com.pc.natusfarma.trademkt.domain.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarefa_cliente")
public class TarefaCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarcli_id")
    private Long id;
    @Column(name = "tarcli_status")
    private String status;

    @Column(name = "tarcli_dataenvio", columnDefinition = "datetime")
    private OffsetDateTime dataEnvio;
    @Column(name = "tarcli_obs")
    private String obs;
    @ManyToOne
    //@JoinColumn(name = "cliente_id", nullable = false, updatable = false, insertable = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tarefa_id", nullable = false)
    private Tarefa tarefa;

    @ManyToMany
    @JoinTable(name = "tarefacliente_anexo",
            joinColumns = @JoinColumn(name = "tarcli_id") ,
            inverseJoinColumns = @JoinColumn(name = "anexo_id"))
    private List<Anexo> anexos = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(OffsetDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    @Override
    public String toString() {
        return "TarefaCliente{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", obs='" + obs + '\'' +
                ", cliente=" + cliente +
                ", tarefa=" + tarefa +
                ", anexos=" + anexos +
                '}';
    }
}
