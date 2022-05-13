package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.TipoDeDano;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TipoDeDanoDTO {
    private Integer idTiposDeDano;
    private String nomeTipoDeDano;
    private String exemploTipoDeDano;

    public static TipoDeDanoDTO create(TipoDeDano tipoDeDano){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoDeDano, TipoDeDanoDTO.class);
    }
}
