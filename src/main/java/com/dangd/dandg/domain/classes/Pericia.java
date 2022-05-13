package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "pericias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pericia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPericia;
    private String nomePericia;
    private String descricaoPericia;
    @ManyToOne
    @JoinColumn(name = "fkAtributo")
    private Atributo atributo;
}
