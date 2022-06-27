package com.dangd.dandg.domain.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "propriedadesArmas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropriedadeArma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropriedadeArma;
    private String nomePorpriedadeArma;
    private String descricaoPropriedadeArma;
}
