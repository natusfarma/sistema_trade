package com.pc.natusfarma.trademkt.api.assembler;

import com.pc.natusfarma.trademkt.api.model.ClienteModel;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ClienteModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteModel toModel(Cliente cliente) {
        return modelMapper.map(cliente, ClienteModel.class);
//        ClienteModel clienteModel = new ClienteModel();
//        clienteModel.setId(cliente.getId());
//        clienteModel.setNome(cliente.getNome());
//        clienteModel.setStatus(cliente.getStatus());
//        return clienteModel;
    }

    public List<ClienteModel> toCollectionModel(List<Cliente> clientes){
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect(Collectors.toList());
    }

}
