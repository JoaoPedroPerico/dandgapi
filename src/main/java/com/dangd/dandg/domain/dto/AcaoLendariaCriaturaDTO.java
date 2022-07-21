package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.AcaoLendariaCriatura;
import com.dangd.dandg.domain.classes.Criatura;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AcaoLendariaCriaturaDTO {
    private Integer idAcaoLendariaCriatura;
    private String nomeAcaoLendaria;
    private String descricaoAcaoLendaria;
    private Criatura criatura;

    public static AcaoLendariaCriaturaDTO create(AcaoLendariaCriatura acaoLendariaCriatura){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(acaoLendariaCriatura, AcaoLendariaCriaturaDTO.class);
    }
}
