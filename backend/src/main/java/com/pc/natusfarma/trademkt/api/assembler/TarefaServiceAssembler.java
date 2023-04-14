package com.pc.natusfarma.trademkt.api.assembler;

import com.pc.natusfarma.trademkt.domain.model.Subcategoria;
import com.pc.natusfarma.trademkt.domain.model.Tarefa;
import com.pc.natusfarma.trademkt.domain.service.model.TarefaServiceInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TarefaServiceAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public Tarefa toModel(TarefaServiceInput tarefaServiceInput) {
        return modelMapper.map(tarefaServiceInput, Tarefa.class);
//        Tarefa tarefa = new Tarefa();
//        tarefa.setId(tarefaServiceInput.getId());
//        tarefa.setDescricao(tarefaServiceInput.getDescricao());
//        tarefa.setTitulo(tarefaServiceInput.getTitulo());
//        tarefa.setDataTarefa(OffsetDateTime.of(tarefaServiceInput.getDataTarefa().atTime(LocalTime.now()), ZoneOffset.UTC));
//        tarefa.setHoraLimite(OffsetTime.of(tarefaServiceInput.getHoraLimite(), ZoneOffset.UTC));
//        Subcategoria subcategoria = new Subcategoria();
//        subcategoria.setId(tarefaServiceInput.getSubcategoriaId().getId());
//        tarefa.setSubcategoria(subcategoria);
//        tarefa.setAnexos(tarefaServiceInput.getAnexos());
//        return tarefa;
    }
}
