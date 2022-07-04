package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.AcaoCriatura;
import com.dangd.dandg.domain.classes.Criatura;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AcaoCriaturaDTO {
    private Integer idAcaoCriatura;
    private String nomeAcao;
    private String descricaoAcao;
    private Criatura criatura;

    public static AcaoCriaturaDTO create(AcaoCriatura acaoCriatura){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(acaoCriatura, AcaoCriaturaDTO.class);
    }
}
