package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.Idioma;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class IdiomaDTO {
    private Integer idIdioma;
    private String nomeIdioma;
    private String falantesIdioma;
    private String alfabetoIdioma;
    private String tipoIdioma;

    public static IdiomaDTO create(Idioma idioma){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(idioma, IdiomaDTO.class);
    }
}
