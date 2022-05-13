package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Atributo;
import com.dangd.dandg.domain.classes.Pericia;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PericiaDTO {
    private Integer idPericia;
    private String nomePericia;
    private String descricaoPericia;
    private Atributo atributo;

    public static PericiaDTO create(Pericia pericia){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pericia, PericiaDTO.class);
    }
}
