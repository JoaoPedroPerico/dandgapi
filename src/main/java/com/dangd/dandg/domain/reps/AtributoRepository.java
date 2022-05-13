package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Atributo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtributoRepository extends JpaRepository<Atributo, Integer> {

    Optional<Atributo> findByAbreviacaoAtributo(String abreviacaoAtributo);
}
