package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Definicao;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DefinicaoDTO {
    private Integer idDefinicao;
    private String nomeDefinicao;
    private String descricaoDefinicao;

    public static DefinicaoDTO create(Definicao definicao){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(definicao, DefinicaoDTO.class);
    }
}
