package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

@Entity(name = "condicoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCondicao;
    private String nomeCondicao;
    private String descricaoCondicao;
}
