package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Criatura;
import com.dangd.dandg.domain.dto.CriaturaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.CriaturaRepository;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriaturaService {
    @Autowired
    private CriaturaRepository rep;

    public List<CriaturaDTO> getCriaturas() {
        List<Criatura> criaturas = rep.findAll();
        List<CriaturaDTO> criaturasDTO = new ArrayList<>();
        for(Criatura criatura : criaturas){
            criaturasDTO.add(CriaturaDTO.create(criatura));
        }
        return criaturasDTO;
    }

    public CriaturaDTO getCriaturaById(Integer id) {
        Optional<Criatura> criatura = rep.findById(id);
        return criatura.map(CriaturaDTO::create).orElseThrow(()-> new ObjectNotFoundException("Criatura não encontrada"));
    }

    public List<CriaturaDTO> getCriaturasByTipoCriatura(String tipoCriatura) {
        List<Criatura> criaturas = rep.findByTipoCriatura(tipoCriatura);
        List<CriaturaDTO> criaturasDTO = new ArrayList<>();
        for(Criatura criatura : criaturas){
            criaturasDTO.add(CriaturaDTO.create(criatura));
        }
        return criaturasDTO;
    }

    public CriaturaDTO create(Criatura criatura) {
        Assert.isNull(criatura.getIdCriatura(), "Não foi possível inserir o registro");
        return CriaturaDTO.create(rep.save(criatura));
    }

    public CriaturaDTO update(Criatura criatura, Integer id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");
        Optional<Criatura> optional = rep.findById(id);
        if(optional.isPresent()){
            Criatura temp = optional.get();
            temp.setNomeCriatura(criatura.getNomeCriatura());
            temp.setTipoCriatura(criatura.getTipoCriatura());
            rep.save(temp);

            return CriaturaDTO.create(temp);
        }else{
            return null;
        }
    }

    public void delete(Integer id) {
        rep.deleteById(id);
    }
}
