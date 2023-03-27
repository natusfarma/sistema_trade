package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.CategoriaNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.exception.EntidadeEmUsoException;
import com.pc.natusfarma.trademkt.domain.model.Categoria;
import com.pc.natusfarma.trademkt.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria buscaPorId(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException(id));
    }

    @Transactional
    public void excluir(Long id){
        try{
            categoriaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new CategoriaNaoEncontradaException(id);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Categoria de código %d não pode ser removida, pois está em uso.", id)
            );
        }
    }
}
