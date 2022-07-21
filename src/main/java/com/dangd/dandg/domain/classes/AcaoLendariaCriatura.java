package com.dangd.dandg.domain.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "acoesLendariasCriaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcaoLendariaCriatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcaoLendariaCriatura;
    private String nomeAcaoLendaria;
    private String descricaoAcaoLendaria;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fkIdCriatura")
    private Criatura criatura;
}
