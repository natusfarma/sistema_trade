package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.PerfilNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Perfil;
import com.pc.natusfarma.trademkt.domain.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil buscarPorId(Long id){
        return perfilRepository.findById(id)
                .orElseThrow(() -> new PerfilNaoEncontradaException(id));
    }

    public Perfil salvar(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public void excluir(Long id){
        try{
            perfilRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new PerfilNaoEncontradaException(id);
        }
    }


}
