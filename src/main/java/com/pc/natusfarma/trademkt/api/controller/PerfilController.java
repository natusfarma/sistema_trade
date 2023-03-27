package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.model.Perfil;
import com.pc.natusfarma.trademkt.domain.repository.PerfilRepository;
import com.pc.natusfarma.trademkt.domain.service.PerfilService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;
    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/{id}")
    public Perfil buscarPorId(@PathVariable Long id){
        return perfilService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil adicionar(@RequestBody Perfil perfil){
        return perfilService.salvar(perfil);
    }

    @PutMapping("/{id}")
    public Perfil atualizar(@RequestBody Perfil perfil, @PathVariable Long id){
        Perfil perfilAtual = perfilService.buscarPorId(id);

        BeanUtils.copyProperties(perfil, perfilAtual, "id");

        return perfilService.salvar(perfilAtual);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        perfilService.excluir(id);
    }





}
