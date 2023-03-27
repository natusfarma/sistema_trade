package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.GrupoNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Categoria;
import com.pc.natusfarma.trademkt.domain.model.Grupo;
import com.pc.natusfarma.trademkt.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private CategoriaService categoriaService;

    public Grupo buscarPorId(Long id){
        return grupoRepository.findById(id)
                .orElseThrow(() -> new GrupoNaoEncontradaException(id));
    }

    public List<Grupo> buscarPorIds(List<Long> ids){
        return grupoRepository.findAllById(ids);
    }

    @Transactional
    public Grupo salvar(Grupo grupo){
        Categoria categoria = grupo.getCategoria();
        if (categoria != null){
            Long categoriaId = grupo.getCategoria().getId();
            Categoria categoriaAtual = categoriaService.buscaPorId(categoriaId);
            grupo.setCategoria(categoriaAtual);
        }
        return grupoRepository.save(grupo);
    }

    @Transactional
    public void excluir(Long id){
        try{
            grupoRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new GrupoNaoEncontradaException(id);
        }
    }


}
