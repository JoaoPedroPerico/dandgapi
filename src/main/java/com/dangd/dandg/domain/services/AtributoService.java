package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.dto.AtributoDTO;
import com.dangd.dandg.domain.reps.AtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AtributoService {
    @Autowired
    private AtributoRepository rep;

    public List<AtributoDTO> getAtributos() {
        List<Atributo> atributos = rep.findAll();
        List<AtributoDTO> atributosDTO = new ArrayList<>();
        for (Atributo atributo : atributos){
            atributosDTO.add(AtributoDTO.create(atributo));
        }
        return atributosDTO;
    }

    public Optional<AtributoDTO> getAtributoById(Integer id) {
        Optional<Atributo> atributo = rep.findById(id);
        if(atributo.isPresent()){
            return Optional.of(AtributoDTO.create(atributo.get()));
        }
        return Optional.empty();
    }

    public Optional<AtributoDTO> getAtributoByAbreviacaoAtributo(String abreviacaoAtributo) {
        Optional<Atributo> atributo = rep.findByAbreviacaoAtributo(abreviacaoAtributo);
        if(atributo.isPresent()){
            return Optional.of(AtributoDTO.create(atributo.get()));
        }
        return Optional.empty();
    }
}
