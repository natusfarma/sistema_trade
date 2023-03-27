package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.model.Anexo;
import com.pc.natusfarma.trademkt.domain.service.AnexoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexos")
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @GetMapping("/{id}")
    public Anexo buscarPorId(@PathVariable Long id){
        return anexoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Anexo adicionar(@RequestBody Anexo anexo){
        return anexoService.salvar(anexo);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Anexo> adicionar(@RequestBody List<Anexo> anexos){
        return anexoService.salvar(anexos);
    }

    @PutMapping("/{id}")
    public Anexo atualizar(@RequestBody Anexo anexo,@PathVariable Long id){
        Anexo anexoAtual = anexoService.buscarPorId(id);

        BeanUtils.copyProperties(anexo, anexoAtual, "id");

        return anexoService.salvar(anexoAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        anexoService.excluir(id);
    }

}
