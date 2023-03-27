package com.pc.natusfarma.trademkt.domain.repository;

import com.pc.natusfarma.trademkt.domain.model.Subcategoria;
import com.pc.natusfarma.trademkt.domain.model.TarefaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {

    @Query(value = "select s.* from subcategoria s where s.categoria_id = ?1", nativeQuery = true)
    Optional<List<Subcategoria>> findByCategoriaId(Long id);

}
