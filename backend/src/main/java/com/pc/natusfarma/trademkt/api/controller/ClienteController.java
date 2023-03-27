package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.model.ClienteModel;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import com.pc.natusfarma.trademkt.domain.repository.ClienteRepository;
import com.pc.natusfarma.trademkt.domain.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ClienteModel> listar(){
        return toCollectionModel(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ClienteModel buscar(@PathVariable Long id){
        Cliente cliente = clienteService.buscaPorId(id);

        ClienteModel clienteModel = toModel(cliente);

        return clienteModel;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente cliente,@PathVariable Long id){
        Cliente clienteAtual = clienteService.buscaPorId(id);

        BeanUtils.copyProperties(cliente, clienteAtual, "id", "dataCadastro");

        return clienteService.salvar(clienteAtual);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        clienteService.excluir(id);
    }

    private ClienteModel toModel(Cliente cliente) {
        return modelMapper.map(cliente, ClienteModel.class);
//        ClienteModel clienteModel = new ClienteModel();
//        clienteModel.setId(cliente.getId());
//        clienteModel.setNome(cliente.getNome());
//        clienteModel.setStatus(cliente.getStatus());
//        return clienteModel;
    }

    private List<ClienteModel> toCollectionModel(List<Cliente> clientes){
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect(Collectors.toList());
    }



}
