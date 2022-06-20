package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Definicao;
import com.dangd.dandg.domain.dto.DefinicaoDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.DefinicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefinicaoService {
    @Autowired
    private DefinicaoRepository rep;

    public List<DefinicaoDTO> getDefinicoes() {
        List<Definicao> definicoes = rep.findAll();
        List<DefinicaoDTO> definicoesDTO = new ArrayList<>();
        for (Definicao definicao : definicoes){
            definicoesDTO.add(DefinicaoDTO.create(definicao));
        }
        return definicoesDTO;
    }

    public DefinicaoDTO getDefinicaoById(Integer id) {
        Optional<Definicao> definicao = rep.findById(id);
        return definicao.map(DefinicaoDTO::create).orElseThrow(()-> new ObjectNotFoundException("Definição não encontrada"));
    }
}
