package com.dangd.dandg.domain.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "acoesCriaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcaoCriatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcaoCriatura;
    private String nomeAcao;
    private String descricaoAcao;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fkIdCriatura")
    private Criatura criatura;
}
