package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Condicao;
import com.dangd.dandg.domain.dto.CondicaoDTO;
import com.dangd.dandg.domain.reps.CondicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CondicaoService {
    @Autowired
    private CondicaoRepository rep;

    public List<CondicaoDTO> getCondicoes() {
        List<Condicao> condicoes = rep.findAll();
        List<CondicaoDTO> condicoesDTO = new ArrayList<>();
        for (Condicao condicao : condicoes){
            condicoesDTO.add(CondicaoDTO.create(condicao));
        }
        return condicoesDTO;
    }

    public Optional<CondicaoDTO> getCondicaoById(Integer id) {
        Optional<Condicao> condicao = rep.findById(id);
        if(condicao.isPresent()){
            return Optional.of(CondicaoDTO.create(condicao.get()));
        }
        return Optional.empty();
    }
}
