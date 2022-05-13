package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "tiposDeDano")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeDano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTiposDeDano;
    private String nomeTipoDeDano;
    private String exemploTipoDeDano;
}
