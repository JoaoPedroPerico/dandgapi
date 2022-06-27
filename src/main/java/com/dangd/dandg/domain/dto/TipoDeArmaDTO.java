package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.TipoDeArma;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TipoDeArmaDTO {
    private Integer idTipoDeArma;
    private String nomeTipoDeArma;

    public static TipoDeArmaDTO create(TipoDeArma tipoDeArma){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipoDeArma, TipoDeArmaDTO.class);
    }
}
