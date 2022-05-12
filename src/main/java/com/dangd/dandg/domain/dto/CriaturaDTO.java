package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Criatura;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CriaturaDTO {
    private Integer idCriatura;
    private String nomeCriatura;
    private String tipoCriatura;

    public static CriaturaDTO create(Criatura criatura){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(criatura, CriaturaDTO.class);
    }
}
