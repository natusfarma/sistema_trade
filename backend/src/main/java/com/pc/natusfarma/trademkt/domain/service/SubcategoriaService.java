package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.CategoriaNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Categoria;
import com.pc.natusfarma.trademkt.domain.model.Subcategoria;
import com.pc.natusfarma.trademkt.domain.repository.SubcategoriaRepository;
import com.pc.natusfarma.trademkt.domain.exception.EntidadeEmUsoException;
import com.pc.natusfarma.trademkt.domain.exception.SubcategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subCategoriaRepository;

    @Autowired
    private CategoriaService categoriaService;


    public Subcategoria buscarPorId(Long id){
        return subCategoriaRepository.findById(id)
                .orElseThrow(() -> new SubcategoriaNaoEncontradaException(id));
    }

    public List<Subcategoria> buscarPorCategoriaId(Long id){
        return subCategoriaRepository.findByCategoriaId(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    @Transactional
    public Subcategoria salvar(Subcategoria subcategoria){
        Long categoriaId = subcategoria.getCategoria().getId();
        Categoria categoria = categoriaService.buscaPorId(categoriaId);

        subcategoria.setCategoria(categoria);

        return subCategoriaRepository.save(subcategoria);
    }

    @Transactional
    public Subcategoria salvarSubECategoria(Subcategoria subcategoria){
        Long categoriaId = subcategoria.getCategoria().getId();
        Categoria categoria;
        if(categoriaId == null){
            categoria = categoriaService.salvar(subcategoria.getCategoria());
        }else{
            categoria = categoriaService.buscaPorId(categoriaId);
        }

        subcategoria.setCategoria(categoria);

        return subCategoriaRepository.save(subcategoria);
    }

    @Transactional
    public void excluir(Long id){
        try{
            subCategoriaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new SubcategoriaNaoEncontradaException(id);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                String.format("Subcategoria de código %d não pode ser removido, pois está em uso.",id));
        }

    }


}
