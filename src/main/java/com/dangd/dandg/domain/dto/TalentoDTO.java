package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.classes.Talento;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TalentoDTO {
    private Integer idTalento;
    private String nomeTalento;
    private String descricaoTalento;
    private String preReqTalento;

    public static TalentoDTO create(Talento talento){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(talento, TalentoDTO.class);
    }
}
