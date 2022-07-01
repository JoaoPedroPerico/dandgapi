package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.TipoDeCriatura;
import com.dangd.dandg.domain.dto.TipoDeCriaturaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.TipoDeCriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDeCriaturaService {
    @Autowired
    private TipoDeCriaturaRepository rep;

    public List<TipoDeCriaturaDTO> getTiposDeCriaturas() {
        List<TipoDeCriatura> tiposDeCriaturas = rep.findAll();
        List<TipoDeCriaturaDTO> tiposDeCriaturasDTO = new ArrayList<>();
        for (TipoDeCriatura tipoDeCriatura : tiposDeCriaturas){
            tiposDeCriaturasDTO.add(TipoDeCriaturaDTO.create(tipoDeCriatura));
        }
        return tiposDeCriaturasDTO;
    }

    public TipoDeCriaturaDTO getTipoDeCriaturaById(Integer id) {
        Optional<TipoDeCriatura> tipoDeCriatura = rep.findById(id);
        return tipoDeCriatura.map(TipoDeCriaturaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Tipo de criatura não encontrada"));
    }
}
