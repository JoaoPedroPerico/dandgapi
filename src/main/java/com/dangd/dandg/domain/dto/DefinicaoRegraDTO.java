package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.DefinicaoRegra;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class DefinicaoRegraDTO {
    private Integer idDefReg;
    private String nomeDefReg;
    private String descricaoDefReg;

    public static DefinicaoRegraDTO create(DefinicaoRegra defReg){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(defReg, DefinicaoRegraDTO.class);
    }
}
