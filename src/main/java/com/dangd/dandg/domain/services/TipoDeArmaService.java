package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.TipoDeArma;
import com.dangd.dandg.domain.dto.TipoDeArmaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.TipoDeArmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoDeArmaService {
    @Autowired
    private TipoDeArmaRepository rep;

    public List<TipoDeArmaDTO> getTiposDeArmas() {
        List<TipoDeArma> tiposDeArmas = rep.findAll();
        List<TipoDeArmaDTO> tiposDeArmasDTO = new ArrayList<>();
        for (TipoDeArma tipoDeArma : tiposDeArmas){
            tiposDeArmasDTO.add(TipoDeArmaDTO.create(tipoDeArma));
        }
        return tiposDeArmasDTO;
    }

    public TipoDeArmaDTO getTipoDeArmaById(Integer id) {
        Optional<TipoDeArma> tipoDeArma = rep.findById(id);
        return tipoDeArma.map(TipoDeArmaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Tipo de arma não encontrado"));
    }
}
