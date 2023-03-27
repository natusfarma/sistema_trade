package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.AnexoNaoEncontradaException;
import com.pc.natusfarma.trademkt.domain.model.Anexo;
import com.pc.natusfarma.trademkt.domain.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository anexoRepository;

    public Anexo buscarPorId(Long id){
        return anexoRepository.findById(id)
                .orElseThrow(() -> new AnexoNaoEncontradaException(id));
    }

    @Transactional
    public Anexo salvar(Anexo anexo){
        return anexoRepository.save(anexo);
    }

    @Transactional
    public List<Anexo> salvar(List<Anexo> anexos){
        return anexoRepository.saveAll(anexos);
    }

    @Transactional
    public void excluir(Long id){
        try{
            anexoRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new AnexoNaoEncontradaException(id);
        }
    }


}
