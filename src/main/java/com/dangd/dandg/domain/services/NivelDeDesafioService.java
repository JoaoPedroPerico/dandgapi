package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.NivelDeDesafio;
import com.dangd.dandg.domain.dto.NivelDeDesafioDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.NivelDeDesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NivelDeDesafioService {
    @Autowired
    private NivelDeDesafioRepository rep;

    public List<NivelDeDesafioDTO> getNiveisDeDesafio() {
        List<NivelDeDesafio> niveisDeDesafio = rep.findAll();
        List<NivelDeDesafioDTO> niveisDeDesafioDTO = new ArrayList<>();
        for (NivelDeDesafio nivelDeDesafio : niveisDeDesafio){
            niveisDeDesafioDTO.add(NivelDeDesafioDTO.create(nivelDeDesafio));
        }
        return niveisDeDesafioDTO;
    }

    public NivelDeDesafioDTO getNivelDeDesafioById(Integer id) {
        Optional<NivelDeDesafio> nivelDeDesafio = rep.findById(id);
        return nivelDeDesafio.map(NivelDeDesafioDTO::create).orElseThrow(()-> new ObjectNotFoundException("Nivel de desafio não encontrado"));
    }
}
