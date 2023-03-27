package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.model.Subcategoria;
import com.pc.natusfarma.trademkt.domain.repository.SubcategoriaRepository;
import com.pc.natusfarma.trademkt.domain.service.SubcategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @GetMapping
    public List<Subcategoria> listar(){
        return subcategoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subcategoria buscarPorId(@PathVariable Long id){
        return subcategoriaService.buscarPorId(id);
    }

    @GetMapping("/categorias/{id}")
    public List<Subcategoria> buscarPorCategoriaId(@PathVariable Long id){
        return subcategoriaService.buscarPorCategoriaId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subcategoria adicionar(@RequestBody Subcategoria subcategoria){
        return subcategoriaService.salvar(subcategoria);
    }

    @PostMapping("/adds")
    @ResponseStatus(HttpStatus.CREATED)
    public Subcategoria adicionarSubECategoria(@RequestBody Subcategoria subcategoria){
        return subcategoriaService.salvarSubECategoria(subcategoria);
    }

    @PutMapping("/{id}")
    public Subcategoria atualizar(@RequestBody Subcategoria subcategoria, @PathVariable Long id){
        Subcategoria subcategoriaAtual = subcategoriaService.buscarPorId(id);

        BeanUtils.copyProperties(subcategoria, subcategoriaAtual, "id");

        return subcategoriaService.salvar(subcategoriaAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        subcategoriaService.excluir(id);
    }





}
