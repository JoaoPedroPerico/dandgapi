package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.NivelDeDesafio;
import com.dangd.dandg.domain.classes.ProficienciaPorND;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProficienciaPorNDDTO {
    private Integer idBonusDeProficienciaPorND;
    private NivelDeDesafio nivelDeDesafio;
    private Integer bonus;

    public static ProficienciaPorNDDTO create(ProficienciaPorND proficienciaPorND){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(proficienciaPorND, ProficienciaPorNDDTO.class);
    }
}
