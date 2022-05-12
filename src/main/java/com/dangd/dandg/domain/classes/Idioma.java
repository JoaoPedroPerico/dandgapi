package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "idiomas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIdioma;
    private String nomeIdioma;
    private String falantesIdioma;
    private String alfabetoIdioma;
    private String tipoIdioma;
}
