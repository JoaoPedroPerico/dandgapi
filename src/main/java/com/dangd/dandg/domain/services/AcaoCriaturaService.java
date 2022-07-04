package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.AcaoCriatura;
import com.dangd.dandg.domain.classes.TracoEspecial;
import com.dangd.dandg.domain.dto.AcaoCriaturaDTO;
import com.dangd.dandg.domain.dto.TracoEspecialDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.AcaoCriaturaRepository;
import com.dangd.dandg.domain.reps.TracoEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcaoCriaturaService {
    @Autowired
    private AcaoCriaturaRepository rep;

    public List<AcaoCriaturaDTO> getAcoesCriaturas() {
        List<AcaoCriatura> acoesCriaturas = rep.findAll();
        List<AcaoCriaturaDTO> acoesCriaturasDTO = new ArrayList<>();
        for (AcaoCriatura acaoCriatura : acoesCriaturas){
            acoesCriaturasDTO.add(AcaoCriaturaDTO.create(acaoCriatura));
        }
        return acoesCriaturasDTO;
    }

    public AcaoCriaturaDTO getAcaoCriaturaById(Integer id) {
        Optional<AcaoCriatura> acaoCriatura = rep.findById(id);
        return acaoCriatura.map(AcaoCriaturaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Ação não encontrado"));
    }
}
