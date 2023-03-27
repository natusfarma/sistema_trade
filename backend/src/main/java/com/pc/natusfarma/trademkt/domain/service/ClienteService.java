package com.pc.natusfarma.trademkt.domain.service;

import com.pc.natusfarma.trademkt.domain.exception.ClienteNaoEncontradoException;
import com.pc.natusfarma.trademkt.domain.exception.EntidadeEmUsoException;
import com.pc.natusfarma.trademkt.domain.model.Cliente;
import com.pc.natusfarma.trademkt.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    private final String CLIENTE_EM_USO = "cliente de código %d não pode ser removido, pois está em uso.";
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscaPorId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id){
        try{
            clienteRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ClienteNaoEncontradoException(id);
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format(CLIENTE_EM_USO, id));
        }
    }

}
