package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Tendencia;
import com.dangd.dandg.domain.dto.TendenciaDTO;
import com.dangd.dandg.domain.reps.TendenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TendenciaService {
    @Autowired
    private TendenciaRepository rep;

    public List<TendenciaDTO> getTendencias() {
        List<Tendencia> tendencias = rep.findAll();
        List<TendenciaDTO> tendenciasDTO = new ArrayList<>();
        for (Tendencia tendencia : tendencias){
            tendenciasDTO.add(TendenciaDTO.create(tendencia));
        }
        return tendenciasDTO;
    }

    public Optional<TendenciaDTO> getTendenciaById(Integer id) {
        Optional<Tendencia> tendencia = rep.findById(id);
        if(tendencia.isPresent()){
            return Optional.of(TendenciaDTO.create(tendencia.get()));
        }
        return Optional.empty();
    }

    public Optional<TendenciaDTO> getTendenciaBySigla(String sigla) {
        Optional<Tendencia> tendencia = rep.findByAbreviacaoTendencia(sigla);
        if(tendencia.isPresent()){
            return Optional.of(TendenciaDTO.create(tendencia.get()));
        }
        return Optional.empty();
    }
}
