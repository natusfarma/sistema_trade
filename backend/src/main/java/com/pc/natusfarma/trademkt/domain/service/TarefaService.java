package com.pc.natusfarma.trademkt.domain.service;

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

    public Tarefa buscarPorId(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    @Transactional
    public Tarefa salvar(TarefaServiceInput tarefaServiceInput){
        Tarefa tarefa = toModel(tarefaServiceInput);

        Tarefa finalTarefa = tarefaRepository.save(tarefa);

        List<TarefaCliente> tarefaClientes = tarefaServiceInput.getClientes()
                .stream()
                .map((e) -> {
                    TarefaCliente tarefaCliente = new TarefaCliente();
                    Cliente cliente = new Cliente();
                    cliente.setId(e.getId());
                    tarefaCliente.setCliente(cliente);
                    tarefaCliente.setTarefa(finalTarefa);
                    return tarefaCliente;
                })
                .collect(Collectors.toList());

        System.out.println(">>>>clientes "+tarefaClientes);
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

    private Tarefa toModel(TarefaServiceInput tarefaServiceInput) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(tarefaServiceInput.getId());
        tarefa.setDescricao(tarefaServiceInput.getDescricao());
        tarefa.setTitulo(tarefaServiceInput.getTitulo());
        tarefa.setDataTarefa(OffsetDateTime.of(tarefaServiceInput.getDataTarefa().atTime(LocalTime.now()), ZoneOffset.UTC));
        tarefa.setHoraLimite(OffsetTime.of(tarefaServiceInput.getHoraLimite(), ZoneOffset.UTC));
        Subcategoria subcategoria = new Subcategoria();
        subcategoria.setId(tarefaServiceInput.getSubcategoriaId().getId());
        tarefa.setSubcategoria(subcategoria);
        tarefa.setAnexos(tarefaServiceInput.getAnexos());
        return tarefa;
    }
}
