package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.assembler.TarefaModelAssembler;
import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import com.pc.natusfarma.trademkt.domain.repository.TarefaClienteRepository;
import com.pc.natusfarma.trademkt.domain.service.TarefaClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/tarefas-id/{tarefaId}")
    public List<TarefaCliente> buscarTarefasId(@PathVariable Long tarefaId){
        return tarefaClienteService.buscarTarefaId(tarefaId);
    }

    @GetMapping("/clientes-id/{clienteId}")
    public List<TarefaCliente> buscarClientesId(@PathVariable Long clienteId){
        return tarefaClienteService.buscarClienteId(clienteId);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public TarefaCliente adicionar(@RequestBody TarefaCliente tarefaCliente){
//        return tarefaClienteService.salvar(tarefaCliente);
//    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody TarefaCliente tarefaCliente, @PathVariable Long id){
        TarefaCliente tarefaClienteAtual = tarefaClienteService.buscarPorId(id);

        BeanUtils.copyProperties(tarefaCliente, tarefaClienteAtual, "id");

        TarefaCliente atualizar = tarefaClienteService.salvar(tarefaClienteAtual);
        return ResponseEntity.ok(atualizar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                    @RequestBody Map<String, Object> campos){
        TarefaCliente tarefaClienteAtual = tarefaClienteService.buscarPorId(id);

        if (tarefaClienteAtual == null){
            return ResponseEntity.notFound().build();
        }

        merge(campos, tarefaClienteAtual);

        return atualizar(tarefaClienteAtual, id);
    }

    private void merge(Map<String, Object> camposOrigem, TarefaCliente tarefaCliente) {
        camposOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            System.out.println(nomePropriedade + " = "+valorPropriedade);
        });
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        tarefaClienteService.excluir(id);
    }



}
