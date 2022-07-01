package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.CategoriaDeTamanho;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CategoriaDeTamanhoDTO {
    private Integer idCategoriaDeTamanho;
    private String tamanho;
    private String espaco;

    public static CategoriaDeTamanhoDTO create(CategoriaDeTamanho categoriaDeTamanho){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoriaDeTamanho, CategoriaDeTamanhoDTO.class);
    }
}
