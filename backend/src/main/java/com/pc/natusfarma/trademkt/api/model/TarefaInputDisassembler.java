package com.pc.natusfarma.trademkt.api.model;

import com.pc.natusfarma.trademkt.api.model.input.TarefaInput;
import com.pc.natusfarma.trademkt.domain.service.model.TarefaServiceInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TarefaInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public TarefaServiceInput toModel(TarefaInput tarefaInput) {
        return modelMapper.map(tarefaInput, TarefaServiceInput.class);
//        TarefaServiceInput tarefaServiceInput = new TarefaServiceInput();
//        tarefaServiceInput.setId(tarefaInput.getId());
//        tarefaServiceInput.setDescricao(tarefaInput.getDescricao());
//        tarefaServiceInput.setTitulo(tarefaInput.getTitulo());
//        tarefaServiceInput.setDataTarefa(tarefaInput.getDataTarefa());
//        tarefaServiceInput.setHoraLimite(tarefaInput.getHoraLimite());
//        tarefaServiceInput.setSubcategoriaId(tarefaInput.getSubcategoriaId());
//        tarefaServiceInput.setAnexos(tarefaInput.getAnexos());
//        tarefaServiceInput.setClientes(tarefaInput.getClientes());
//        return tarefaServiceInput;
    }

}
