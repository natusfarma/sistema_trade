package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.TarefeClienteNaoEncontradoException;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import com.pc.natusfarma.trademkt.domain.model.Tarefa;
import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import com.pc.natusfarma.trademkt.domain.repository.TarefaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class TarefaClienteService {

    @Autowired
    private TarefaClienteRepository tarefaClienteRepository;
    @Autowired
    @Lazy
    private TarefaService tarefaService;
    @Autowired
    private ClienteService clienteService;

    public TarefaCliente buscarTarefaIdEClienteId(Long tarefaId, Long clienteId){
        return tarefaClienteRepository.findByTarefaIdAndClienteId(tarefaId, clienteId)
                .orElseThrow(() -> new TarefeClienteNaoEncontradoException(tarefaId, clienteId));
    }

    public TarefaCliente buscarPorId(Long id){
        return tarefaClienteRepository.findById(id)
                .orElseThrow(() -> new TarefeClienteNaoEncontradoException(id));
    }

    @Transactional
    public TarefaCliente salvar(TarefaCliente tarefaCliente){
        Long tarefaId = tarefaCliente.getTarefa().getId();
        Long clienteId = tarefaCliente.getCliente().getId();

        Tarefa tarefa = tarefaService.buscarPorId(tarefaId);
        Cliente cliente = clienteService.buscaPorId(clienteId);

        tarefaCliente.setTarefa(tarefa);
        tarefaCliente.setCliente(cliente);

        return tarefaClienteRepository.save(tarefaCliente);
    }

    @Transactional
    public List<TarefaCliente> salvar(List<TarefaCliente> tarefaClientes){
        return tarefaClienteRepository.saveAll(tarefaClientes);
    }


    @Transactional
    public void excluir(Long id){
        try{
            tarefaClienteRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new TarefeClienteNaoEncontradoException(id);
        }
    }

}
