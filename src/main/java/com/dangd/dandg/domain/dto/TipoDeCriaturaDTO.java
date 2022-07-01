package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.TipoDeCriatura;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TipoDeCriaturaDTO {
    private Integer idTipoDeCriatura;
    private String nome;
    private String descricao;

    public static TipoDeCriaturaDTO create(TipoDeCriatura tipoDeCriatura){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoDeCriatura, TipoDeCriaturaDTO.class);
    }
}
