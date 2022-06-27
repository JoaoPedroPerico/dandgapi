package com.dangd.dandg.domain.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "propriedadesArmas_armas",
            joinColumns = @JoinColumn(name = "fkArma", referencedColumnName = "idArma"),
            inverseJoinColumns = @JoinColumn(name = "fkPropriedadeArma", referencedColumnName = "idPropriedadeArma"))
    private List<PropriedadeArma> propriedadesArma;
}
