package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {


}
