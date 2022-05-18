package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Condicao;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CondicaoDTO {
    private Integer idCondicao;
    private String nomeCondicao;
    private String descricaoCondicao;

    public static CondicaoDTO create(Condicao condicao){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(condicao, CondicaoDTO.class);
    }
}
