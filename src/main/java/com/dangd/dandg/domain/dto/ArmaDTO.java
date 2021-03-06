package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Arma;
import com.dangd.dandg.domain.classes.PropriedadeArma;
import com.dangd.dandg.domain.classes.TipoDeArma;
import com.dangd.dandg.domain.classes.TipoDeDano;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class ArmaDTO {
    private Integer idArma;
    private String nomeArma;
    private String precoArma;
    private String danoArma;
    private TipoDeDano tipoDeDano;
    private String pesoArma;
    private TipoDeArma tipoDeArma;
    private List<PropriedadeArma> propriedadesArma;

    public static ArmaDTO create(Arma arma){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(arma, ArmaDTO.class);
    }
}
