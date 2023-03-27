package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaClienteRepository extends JpaRepository<TarefaCliente, Long> {

    Optional<TarefaCliente> findByTarefaIdAndClienteId(Long tarefaId, Long clienteId);

    List<TarefaCliente> findByTarefaId(Long tarefaId);

}
