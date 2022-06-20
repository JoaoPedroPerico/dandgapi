package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Regra;
import com.dangd.dandg.domain.dto.RegraDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.RegraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegraService {
    @Autowired
    private RegraRepository rep;

    public List<RegraDTO> getRegras() {
        List<Regra> regras = rep.findAll();
        List<RegraDTO> regrasDTO = new ArrayList<>();
        for (Regra regra : regras){
            regrasDTO.add(RegraDTO.create(regra));
        }
        return regrasDTO;
    }

    public RegraDTO getRegraById(Integer id) {
        Optional<Regra> regra = rep.findById(id);
        return regra.map(RegraDTO::create).orElseThrow(()-> new ObjectNotFoundException("Regra não encontrada"));
    }
}
