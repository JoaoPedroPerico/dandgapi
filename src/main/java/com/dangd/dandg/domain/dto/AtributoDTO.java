package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Atributo;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AtributoDTO {
    private Integer idAtributo;
    private String nomeAtributo;
    private String abreviacaoAtributo;
    private String tomateAtributo;
    private String descricaoAtributo;

    public static AtributoDTO create(Atributo atributo){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(atributo, AtributoDTO.class);
    }
}
