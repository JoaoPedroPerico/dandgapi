package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Tendencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TendenciaRepository extends JpaRepository<Tendencia, Integer> {

    Optional<Tendencia> findByAbreviacaoTendencia(String abreviacaoTendencia);
}
