package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.assembler.ClienteModelAssembler;
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
    private ClienteModelAssembler clienteModelAssembler;

    @GetMapping
    public List<ClienteModel> listar(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteModelAssembler.toCollectionModel(clientes);
    }

    @GetMapping("/{id}")
    public ClienteModel buscar(@PathVariable Long id){
        Cliente cliente = clienteService.buscaPorId(id);

        ClienteModel clienteModel = clienteModelAssembler.toModel(cliente);

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





}
