package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Tendencia;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TendenciaDTO {
    private Integer idTendencia;
    private String nomeTendencia;
    private String abreviacaoTendencia;
    private String descricaoTendencia;

    public static TendenciaDTO create(Tendencia tendencia){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tendencia, TendenciaDTO.class);
    }
}
