package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import com.pc.natusfarma.trademkt.domain.repository.TarefaClienteRepository;
import com.pc.natusfarma.trademkt.domain.service.TarefaClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas-clientes")
public class TarefaClienteController {

    @Autowired
    private TarefaClienteRepository tarefaClienteRepository;
    @Autowired
    private TarefaClienteService tarefaClienteService;

    @GetMapping
    public List<TarefaCliente> listar(){
        return tarefaClienteRepository.findAll();
    }

    @GetMapping("/")
    //tarefas-clientes/?tarefaId=2&clienteId=1
    public TarefaCliente buscarTarefaIdEClienteId(Long tarefaId, Long clienteId){
        System.out.println("valor de tarefaID "+tarefaId);
        System.out.println("valor de clienteId "+clienteId);
        return tarefaClienteService.buscarTarefaIdEClienteId(tarefaId, clienteId);
    }

    @GetMapping("/tarefa-id/{tarefaId}")
    public List<TarefaCliente> buscarTarefaId(@PathVariable Long tarefaId){
        return tarefaClienteService.buscarTarefaId(tarefaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaCliente adicionar(@RequestBody TarefaCliente tarefaCliente){
        return tarefaClienteService.salvar(tarefaCliente);
    }


    @PutMapping("/{id}")
    public TarefaCliente atualizar(@RequestBody TarefaCliente tarefaCliente, @PathVariable Long id){
        TarefaCliente tarefaClienteAtual = tarefaClienteService.buscarPorId(id);

        BeanUtils.copyProperties(tarefaCliente, tarefaClienteAtual, "id");

        return tarefaClienteService.salvar(tarefaClienteAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        tarefaClienteService.excluir(id);
    }



}
