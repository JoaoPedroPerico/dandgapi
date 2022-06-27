package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.PropriedadeArma;
import com.dangd.dandg.domain.dto.PropriedadeArmaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.PropriedadeArmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeArmaService {
    @Autowired
    private PropriedadeArmaRepository rep;

    public List<PropriedadeArmaDTO> getPropriedadesArmas() {
        List<PropriedadeArma> propriedadesArmas = rep.findAll();
        List<PropriedadeArmaDTO> propriedadesArmasDTO = new ArrayList<>();
        for (PropriedadeArma propriedadeArma : propriedadesArmas){
            propriedadesArmasDTO.add(PropriedadeArmaDTO.create(propriedadeArma));
        }
        return propriedadesArmasDTO;
    }

    public PropriedadeArmaDTO getPropriedadeArmaById(Integer id) {
        Optional<PropriedadeArma> propriedadeArma = rep.findById(id);
        return propriedadeArma.map(PropriedadeArmaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Propriedade não encontrada"));
    }
}
