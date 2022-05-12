package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "criaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Criatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCriatura;
    private String nomeCriatura;
    private String tipoCriatura;
}
