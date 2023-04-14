package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.api.model.input.UploadInput;
import com.pc.natusfarma.trademkt.domain.model.Perfil;
import com.pc.natusfarma.trademkt.domain.repository.PerfilRepository;
import com.pc.natusfarma.trademkt.domain.service.PerfilService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;


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
    public Perfil adicionar(UploadInput uploadInput){

        Perfil perfil;
        try {
            perfil = criarPerfil(uploadInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return perfilService.salvar(perfil);
    }

    @PutMapping("/{id}")
    public Perfil atualizar(UploadInput uploadInput, @PathVariable Long id){
        Perfil perfilAtual = perfilService.buscarPorId(id);

        Perfil perfil;
        try {
            perfil = criarPerfil(uploadInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(perfil, perfilAtual, "id", "nome");

        return perfilService.salvar(perfilAtual);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        perfilService.excluir(id);
    }

    private Perfil criarPerfil(UploadInput uploadInput) throws IOException {
        Perfil perfil = new Perfil();
        String nome = uploadInput.getArquivo().getOriginalFilename();
        nome = nome.substring(nome.indexOf("."));
        perfil.setExtensao(nome);
        perfil.setFoto(uploadInput.getArquivo().getBytes());
        perfil.setTamanho(uploadInput.getArquivo().getSize());
        return perfil;
    }



}
