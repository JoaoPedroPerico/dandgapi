package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.classes.Pericia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PericiaRepository extends JpaRepository<Pericia, Integer> {

    List<Pericia> findByAtributo(Atributo atributo);
}
