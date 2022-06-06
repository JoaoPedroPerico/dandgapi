package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.classes.Talento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalentoRepository extends JpaRepository<Talento, Integer> {

    List<Talento> findByAtributo(Atributo atributo);
}
