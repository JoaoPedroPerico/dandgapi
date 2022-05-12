package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "tendencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tendencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTendencia;
    private String nomeTendencia;
    private String abreviacaoTendencia;
    private String descricaoTendencia;
}
