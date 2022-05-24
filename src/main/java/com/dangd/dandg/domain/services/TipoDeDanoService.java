package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.TipoDeDano;
import com.dangd.dandg.domain.dto.TipoDeDanoDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
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

    public TipoDeDanoDTO getTipoDeDanoById(Integer id) {
        Optional<TipoDeDano> tipoDeDano = rep.findById(id);
        return tipoDeDano.map(TipoDeDanoDTO::create).orElseThrow(()-> new ObjectNotFoundException("Tipo de dano não encontrado"));
    }
}
