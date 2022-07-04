package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Criatura;
import com.dangd.dandg.domain.classes.TracoEspecial;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class TracoEspecialDTO {
    private Integer idTracoEspecial;
    private String nomeTraco;
    private String descricaoTraco;
    private Criatura criatura;

    public static TracoEspecialDTO create(TracoEspecial tracoEspecial){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tracoEspecial, TracoEspecialDTO.class);
    }
}
