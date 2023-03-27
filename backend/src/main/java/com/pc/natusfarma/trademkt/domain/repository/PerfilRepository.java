package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {


}
