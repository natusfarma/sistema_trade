package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.model.ClienteModel;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import com.pc.natusfarma.trademkt.domain.model.Grupo;
import com.pc.natusfarma.trademkt.domain.repository.ClienteRepository;
import com.pc.natusfarma.trademkt.domain.service.ClienteService;
import com.pc.natusfarma.trademkt.domain.service.GrupoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private GrupoService grupoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
        return clienteService.buscaPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        List<Long> grupoIds = cliente.getGrupos()
                .stream().map(e -> e.getId())
                .collect(Collectors.toList());
        List<Grupo> grupos = grupoService.buscarPorIds(grupoIds);

        cliente.setGrupos(grupos);
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente cliente,@PathVariable Long id){
        Cliente clienteAtual = clienteService.buscaPorId(id);

        BeanUtils.copyProperties(cliente, clienteAtual, "id", "dataCadastro");

        return clienteService.salvar(clienteAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        clienteService.excluir(id);
    }





}
