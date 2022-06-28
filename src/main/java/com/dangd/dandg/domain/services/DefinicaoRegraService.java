package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.DefinicaoRegra;
import com.dangd.dandg.domain.dto.DefinicaoRegraDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.DefinicaoRegraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefinicaoRegraService {
    @Autowired
    private DefinicaoRegraRepository rep;

    public List<DefinicaoRegraDTO> getDefinicoesERegras() {
        List<DefinicaoRegra> definicoesERegras = rep.findAll();
        List<DefinicaoRegraDTO> definicoesRegrasDTO = new ArrayList<>();
        for (DefinicaoRegra definicaoRegra : definicoesERegras){
            definicoesRegrasDTO.add(DefinicaoRegraDTO.create(definicaoRegra));
        }
        return definicoesRegrasDTO;
    }

    public DefinicaoRegraDTO getDefinicaoRegraById(Integer id) {
        Optional<DefinicaoRegra> definicaoRegra = rep.findById(id);
        return definicaoRegra.map(DefinicaoRegraDTO::create).orElseThrow(()-> new ObjectNotFoundException("Definição/regra não encontrada"));
    }
}
