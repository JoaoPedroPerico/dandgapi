package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.ProficienciaPorND;
import com.dangd.dandg.domain.dto.ProficienciaPorNDDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.ProficienciaPorNDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProficienciaPorNDService {
    @Autowired
    private ProficienciaPorNDRepository rep;

    public List<ProficienciaPorNDDTO> getProficienciasPorND() {
        List<ProficienciaPorND> proficienciasPorND = rep.findAll();
        List<ProficienciaPorNDDTO> proficienciasPorNDDTO = new ArrayList<>();
        for (ProficienciaPorND proficienciaPorND : proficienciasPorND){
            proficienciasPorNDDTO.add(ProficienciaPorNDDTO.create(proficienciaPorND));
        }
        return proficienciasPorNDDTO;
    }

    public ProficienciaPorNDDTO getProficienciaPorNDById(Integer id) {
        Optional<ProficienciaPorND> proficienciaPorND = rep.findById(id);
        return proficienciaPorND.map(ProficienciaPorNDDTO::create).orElseThrow(()-> new ObjectNotFoundException("Proficiencia não encontrada"));
    }
}
