package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.NivelDeDesafio;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class NivelDeDesafioDTO {
    private Integer idNivelDeDesafio;
    private String nivel;
    private Integer experiencia;

    public static NivelDeDesafioDTO create(NivelDeDesafio nivelDeDesafio){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(nivelDeDesafio, NivelDeDesafioDTO.class);
    }
}
