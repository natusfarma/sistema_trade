package com.pc.natusfarma.trademkt.api.assembler;

import com.pc.natusfarma.trademkt.api.model.TarefaModel;
import com.pc.natusfarma.trademkt.domain.model.Tarefa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarefaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    public TarefaModel toModel(Tarefa tarefa){
        return modelMapper.map(tarefa, TarefaModel.class);
    }
}
