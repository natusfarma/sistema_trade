package com.pc.natusfarma.trademkt.api.controller;

import com.pc.natusfarma.trademkt.domain.exception.CategoriaNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Categoria;
import com.pc.natusfarma.trademkt.domain.repository.CategoriaRepository;
import com.pc.natusfarma.trademkt.domain.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        try{
            Categoria categoria = categoriaService.buscaPorId(id);
            return ResponseEntity.ok(categoria);
        }catch (CategoriaNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria adicionar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Categoria categoria, @PathVariable Long id){
            Categoria categoriaAtual = categoriaService.buscaPorId(id);

            BeanUtils.copyProperties(categoria, categoriaAtual, "id", "dataCadastro");

            categoriaAtual = categoriaService.salvar(categoriaAtual);
            return ResponseEntity.ok(categoriaAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable  Long id){
        categoriaService.excluir(id);
    }







}
