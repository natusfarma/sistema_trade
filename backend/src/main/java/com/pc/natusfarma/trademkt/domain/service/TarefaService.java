package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.api.assembler.TarefaServiceAssembler;
import com.pc.natusfarma.trademkt.domain.exception.TarefaNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import com.pc.natusfarma.trademkt.domain.model.Subcategoria;
import com.pc.natusfarma.trademkt.domain.model.Tarefa;
import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import com.pc.natusfarma.trademkt.domain.repository.TarefaRepository;
import com.pc.natusfarma.trademkt.domain.service.model.TarefaServiceInput;
import org.hibernate.id.uuid.StandardRandomStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private SubcategoriaService subCategoriaService;
    @Autowired
    private TarefaClienteService tarefaClienteService;

    @Autowired
    private TarefaServiceAssembler tarefaServiceAssembler;

    public Tarefa buscarPorId(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    @Transactional
    public Tarefa salvar(TarefaServiceInput tarefaServiceInput){
        Tarefa tarefa = tarefaServiceAssembler.toModel(tarefaServiceInput);
        Long subcategoriaId = tarefa.getSubcategoria().getId();

        Subcategoria subcategoria = subCategoriaService.buscarPorId(subcategoriaId);
        tarefa.setSubcategoria(subcategoria);

        Tarefa finalTarefa = tarefaRepository.save(tarefa);

        List<TarefaCliente> tarefaClientes = tarefaServiceInput.getClientes()
                .stream()
                .map((e) -> {
                    TarefaCliente tarefaCliente = new TarefaCliente();
                    Cliente cliente = new Cliente();
                    cliente.setId(e.getId());
                    tarefaCliente.setCliente(cliente);
                    tarefaCliente.setTarefa(finalTarefa);
                    tarefaCliente.setStatus("PENDENTE");
                    return tarefaCliente;
                })
                .collect(Collectors.toList());

        tarefaClienteService.salvar(tarefaClientes);

        return finalTarefa;
    }


    @Transactional
    public void excluir(Long id){
        try{
            tarefaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new TarefaNaoEncontradaException(id);
        }
    }

}
