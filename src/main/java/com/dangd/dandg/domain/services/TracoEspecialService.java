package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Idioma;
import com.dangd.dandg.domain.classes.TracoEspecial;
import com.dangd.dandg.domain.dto.IdiomaDTO;
import com.dangd.dandg.domain.dto.TracoEspecialDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.IdiomaRepository;
import com.dangd.dandg.domain.reps.TracoEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TracoEspecialService {
    @Autowired
    private TracoEspecialRepository rep;

    public List<TracoEspecialDTO> getTracosEspeciais() {
        List<TracoEspecial> tracosEspeciais = rep.findAll();
        List<TracoEspecialDTO> tracosEspeciaisDTO = new ArrayList<>();
        for (TracoEspecial tracoEspecial : tracosEspeciais){
            tracosEspeciaisDTO.add(TracoEspecialDTO.create(tracoEspecial));
        }
        return tracosEspeciaisDTO;
    }

    public TracoEspecialDTO getTracoEspecialById(Integer id) {
        Optional<TracoEspecial> tracoEspecial = rep.findById(id);
        return tracoEspecial.map(TracoEspecialDTO::create).orElseThrow(()-> new ObjectNotFoundException("Traço especial não encontrado"));
    }
}
