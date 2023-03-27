package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.model.Grupo;
import com.pc.natusfarma.trademkt.domain.repository.GrupoRepository;
import com.pc.natusfarma.trademkt.domain.service.GrupoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Grupo buscarPorId(@PathVariable Long id){
        return grupoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo adicionar(@RequestBody Grupo grupo){
        return grupoService.salvar(grupo);
    }

    @PutMapping("/{id}")
    public Grupo atualizar(@RequestBody Grupo grupo,@PathVariable Long id){
        Grupo grupoAtual = grupoService.buscarPorId(id);

        BeanUtils.copyProperties(grupo, grupoAtual, "id");

        return grupoService.salvar(grupoAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        grupoService.excluir(id);
    }

}
