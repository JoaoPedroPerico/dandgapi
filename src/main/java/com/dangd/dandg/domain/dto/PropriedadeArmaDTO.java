package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.PropriedadeArma;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PropriedadeArmaDTO {
    private Integer idPropriedadeArma;
    private String nomePropriedadeArma;
    private String descricaoPropriedadeArma;

    public static PropriedadeArmaDTO create(PropriedadeArma propriedadeArma){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(propriedadeArma, PropriedadeArmaDTO.class);
    }
}
