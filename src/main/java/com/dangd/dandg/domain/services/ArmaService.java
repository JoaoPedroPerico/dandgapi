package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Arma;
import com.dangd.dandg.domain.classes.TipoDeArma;
import com.dangd.dandg.domain.dto.ArmaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.ArmaRepository;
import com.dangd.dandg.domain.reps.TipoDeArmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArmaService {
    @Autowired
    private ArmaRepository armaRepository;
    @Autowired
    private TipoDeArmaRepository tipoDeArmaRepository;

    public List<ArmaDTO> getArmas() {
        List<Arma> armas = armaRepository.findAll();
        List<ArmaDTO> armasDTO = new ArrayList<>();
        for (Arma arma : armas){
            armasDTO.add(ArmaDTO.create(arma));
        }
        return armasDTO;
    }

    public ArmaDTO getArmaById(Integer id) {
        Optional<Arma> arma = armaRepository.findById(id);
        return arma.map(ArmaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Arma não encontrada"));
    }

    public List<ArmaDTO> getArmasByTipoDeArma(Integer tipoDeArmaInt) {
        List<ArmaDTO> armasDTO = new ArrayList<>();
        Optional<TipoDeArma> tipoDeArma = tipoDeArmaRepository.findById(tipoDeArmaInt);
        if(tipoDeArma.isPresent()){
            List<Arma> armas = armaRepository.findByTipoDeArma(tipoDeArma.get());
            for(Arma arma : armas){
                armasDTO.add(ArmaDTO.create(arma));
            }
        }else{
            throw new ObjectNotFoundException("Tipo de arma não encontrada");
        }
        return armasDTO;
    }
}
