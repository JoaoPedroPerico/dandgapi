package com.dangd.dandg.domain.reps;

import com.dangd.dandg.domain.classes.Criatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriaturaRepository extends JpaRepository<Criatura, Integer> {

    List<Criatura> findByTipoCriatura(String tipoCriatura);
}
