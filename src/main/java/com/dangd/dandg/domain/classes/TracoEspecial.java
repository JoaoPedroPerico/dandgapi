package com.dangd.dandg.domain.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "tracosEspeciaisCriaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TracoEspecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTracoEspecial;
    private String nomeTraco;
    private String descricaoTraco;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fkIdCriatura")
    private Criatura criatura;
}
