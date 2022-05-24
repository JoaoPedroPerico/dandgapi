package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Idioma;
import com.dangd.dandg.domain.dto.IdiomaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {
    @Autowired
    private IdiomaRepository rep;

    public List<IdiomaDTO> getIdiomas() {
        List<Idioma> idiomas = rep.findAll();
        List<IdiomaDTO> idiomasDTO = new ArrayList<>();
        for (Idioma idioma : idiomas){
            idiomasDTO.add(IdiomaDTO.create(idioma));
        }
        return idiomasDTO;
    }

    public IdiomaDTO getIdiomaById(Integer id) {
        Optional<Idioma> idioma = rep.findById(id);
        return idioma.map(IdiomaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Idioma não encontrado"));
    }
}
