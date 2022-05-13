package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Idioma;
import com.dangd.dandg.domain.classes.TipoDeDano;
import com.dangd.dandg.domain.dto.IdiomaDTO;
import com.dangd.dandg.domain.dto.TipoDeDanoDTO;
import com.dangd.dandg.domain.reps.TipoDeDanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDeDanoService {
    @Autowired
    private TipoDeDanoRepository rep;

    public List<TipoDeDanoDTO> getTiposDeDano() {
        List<TipoDeDano> tiposDeDano = rep.findAll();
        List<TipoDeDanoDTO> tiposDeDanoDTO = new ArrayList<>();
        for (TipoDeDano tipoDeDano : tiposDeDano){
            tiposDeDanoDTO.add(TipoDeDanoDTO.create(tipoDeDano));
        }
        return tiposDeDanoDTO;
    }

    public Optional<TipoDeDanoDTO> getTipoDeDanoById(Integer id) {
        Optional<TipoDeDano> tipoDeDano = rep.findById(id);
        if(tipoDeDano.isPresent()){
            return Optional.of(TipoDeDanoDTO.create(tipoDeDano.get()));
        }
        return Optional.empty();
    }
}
