package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Pericia;
import com.dangd.dandg.domain.dto.PericiaDTO;
import com.dangd.dandg.domain.reps.PericiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PericiaService {
    @Autowired
    private PericiaRepository rep;

    public List<PericiaDTO> getPericias() {
        List<Pericia> pericias = rep.findAll();
        List<PericiaDTO> periciasDTO = new ArrayList<>();
        for (Pericia pericia : pericias){
            periciasDTO.add(PericiaDTO.create(pericia));
        }
        return periciasDTO;
    }

    public Optional<PericiaDTO> getPericiaById(Integer id) {
        Optional<Pericia> pericia = rep.findById(id);
        if(pericia.isPresent()){
            return Optional.of(PericiaDTO.create(pericia.get()));
        }
        return Optional.empty();
    }
}
