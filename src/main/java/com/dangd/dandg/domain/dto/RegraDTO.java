package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Regra;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class RegraDTO {
    private Integer idRegra;
    private String nomeRegra;
    private String descricaoRegra;

    public static RegraDTO create(Regra regra){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(regra, RegraDTO.class);
    }
}
