package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
