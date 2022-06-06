package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "talentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTalento;
    private String nomeTalento;
    private String descricaoTalento;
    private Integer valorMinimoAtributo;
    @ManyToOne
    @JoinColumn(name = "fkAtributo")
    private Atributo atributo;
}
