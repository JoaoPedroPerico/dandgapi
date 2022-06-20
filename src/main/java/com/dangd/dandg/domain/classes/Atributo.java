package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "atributos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atributo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtributo;
    private String nomeAtributo;
    private String abreviacaoAtributo;
    private String tomateAtributo;
    private String descricaoAtributo;
    private String testesDoAtributo;
    private String descricaoComplementar;
}
