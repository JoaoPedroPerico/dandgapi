package com.dangd.dandg.domain.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "bonusDeProficienciaPorND")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProficienciaPorND implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBonusDeProficienciaPorND;
    @OneToOne
    @JoinColumn(name = "fkNivelDeDesafio")
    private NivelDeDesafio nivelDeDesafio;
    private Integer bonus;
}
