package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
