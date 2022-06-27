package com.dangd.dandg.domain.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "armas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArma;
    private String nomeArma;
    private String precoArma;
    private String danoArma;
    @ManyToOne
    @JoinColumn(name = "fkTipoDeDano")
    private TipoDeDano tipoDeDano;
    private String pesoArma;
    @ManyToOne
    @JoinColumn(name = "fkTipoDeArma")
    private TipoDeArma tipoDeArma;
}
