package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Arma;
import com.dangd.dandg.domain.classes.TipoDeArma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArmaRepository extends JpaRepository<Arma, Integer> {

    List<Arma> findByTipoDeArma(TipoDeArma tipoDeArma);
}
