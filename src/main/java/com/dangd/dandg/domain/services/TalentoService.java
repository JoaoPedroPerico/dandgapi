package com.dangd.dandg.domain.services;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.classes.Talento;
import com.dangd.dandg.domain.dto.TalentoDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.reps.AtributoRepository;
import com.dangd.dandg.domain.reps.TalentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TalentoService {
    @Autowired
    private TalentoRepository talentoRepository;
    @Autowired
    private AtributoRepository atributoRepository;

    public List<TalentoDTO> getTalentos() {
        List<Talento> talentos = talentoRepository.findAll();
        List<TalentoDTO> talentosDTO = new ArrayList<>();
        for (Talento talento : talentos){
            talentosDTO.add(TalentoDTO.create(talento));
        }
        return talentosDTO;
    }

    public TalentoDTO getTalentoById(Integer id) {
        Optional<Talento> talento = talentoRepository.findById(id);
        return talento.map(TalentoDTO::create).orElseThrow(()-> new ObjectNotFoundException("Talento não encontrado"));
    }

    public List<TalentoDTO> getTalentosByModificador(String abreviacaoAtributo) {
        List<TalentoDTO> talentosDTO = new ArrayList<>();
        Optional<Atributo> atributo = atributoRepository.findByAbreviacaoAtributo(abreviacaoAtributo);
        if(atributo.isPresent()){
            List<Talento> talentos = talentoRepository.findByAtributo(atributo.get());
            for(Talento talento : talentos){
                talentosDTO.add(TalentoDTO.create(talento));
            }
        }else{
            throw new ObjectNotFoundException("Atributo não encontrado");
        }
        return talentosDTO;
    }
}
