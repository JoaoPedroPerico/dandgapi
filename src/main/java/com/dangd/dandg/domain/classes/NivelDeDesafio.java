package com.dangd.dandg.domain.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "niveisDeDesafio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelDeDesafio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNivelDeDesafio;
    private String nivel;
    private Integer experiencia;
}
