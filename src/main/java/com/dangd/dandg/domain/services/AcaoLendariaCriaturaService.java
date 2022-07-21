package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.AcaoLendariaCriatura;
import com.dangd.dandg.domain.dto.AcaoLendariaCriaturaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.AcaoLendariaCriaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcaoLendariaCriaturaService {
    @Autowired
    private AcaoLendariaCriaturaRepository rep;

    public List<AcaoLendariaCriaturaDTO> getAcoesLendariasCriaturas() {
        List<AcaoLendariaCriatura> acoesLendariasCriaturas = rep.findAll();
        List<AcaoLendariaCriaturaDTO> acoesLendariasCriaturasDTO = new ArrayList<>();
        for (AcaoLendariaCriatura acaoLendariaCriatura : acoesLendariasCriaturas){
            acoesLendariasCriaturasDTO.add(AcaoLendariaCriaturaDTO.create(acaoLendariaCriatura));
        }
        return acoesLendariasCriaturasDTO;
    }

    public AcaoLendariaCriaturaDTO getAcaoLendariaCriaturaById(Integer id) {
        Optional<AcaoLendariaCriatura> acaoLendariaCriatura = rep.findById(id);
        return acaoLendariaCriatura.map(AcaoLendariaCriaturaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Ação lendaria não encontrado"));
    }
}
