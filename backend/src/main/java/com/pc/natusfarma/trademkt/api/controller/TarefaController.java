package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.model.TarefaModel;
import com.pc.natusfarma.trademkt.api.model.input.TarefaInput;
import com.pc.natusfarma.trademkt.domain.model.Tarefa;
import com.pc.natusfarma.trademkt.domain.repository.SubcategoriaRepository;
import com.pc.natusfarma.trademkt.domain.repository.TarefaRepository;
import com.pc.natusfarma.trademkt.domain.service.TarefaService;
import com.pc.natusfarma.trademkt.domain.service.model.TarefaServiceInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private SubcategoriaRepository subCategoriaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<Tarefa> listar(){
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public TarefaModel buscarPorId(@PathVariable Long id){
        return toModel(tarefaService.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa salvar(@RequestBody TarefaInput tarefaInput){
        TarefaServiceInput tarefaServiceInput = toModel(tarefaInput);

        return tarefaService.salvar(tarefaServiceInput);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@RequestBody Tarefa tarefa, @PathVariable Long id){
        Tarefa tarefaAtual = tarefaService.buscarPorId(id);

        BeanUtils.copyProperties(tarefa, tarefaAtual, "id","dataCadastro");

        return tarefaService.salvar(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        tarefaService.excluir(id);
    }

    private TarefaServiceInput toModel(TarefaInput tarefaInput) {
        TarefaServiceInput tarefaServiceInput = new TarefaServiceInput();
        tarefaServiceInput.setId(tarefaInput.getId());
        tarefaServiceInput.setDescricao(tarefaInput.getDescricao());
        tarefaServiceInput.setTitulo(tarefaInput.getTitulo());
        tarefaServiceInput.setDataTarefa(tarefaInput.getDataTarefa());
        tarefaServiceInput.setHoraLimite(tarefaInput.getHoraLimite());
        tarefaServiceInput.setSubcategoriaId(tarefaInput.getSubcategoriaId());
        tarefaServiceInput.setAnexos(tarefaInput.getAnexos());
        tarefaServiceInput.setClientes(tarefaInput.getClientes());
        return tarefaServiceInput;
    }

    private TarefaModel toModel(Tarefa tarefa){
        return modelMapper.map(tarefa, TarefaModel.class);
    }
}
