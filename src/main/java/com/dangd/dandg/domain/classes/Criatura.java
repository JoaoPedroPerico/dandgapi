package com.dangd.dandg.domain.classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity(name = "criaturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Criatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCriatura;
    private String nomeCriatura;
    @ManyToOne
    @JoinColumn(name = "fkTipoDeCriatura")
    private TipoDeCriatura tipoCriatura;
    private String tipoDeCriaturaExtra;
    @ManyToOne
    @JoinColumn(name = "fkCategoriaDeTamanho")
    private CategoriaDeTamanho categoriaDeTamanho;
    @ManyToOne
    @JoinColumn(name = "fkTendencia")
    private Tendencia tendencia;
    private Integer classeDeArmadura;
    private String tipoDeArmadura;
    private Integer pontosDeVida;
    private String formulaVida;
    private Float deslocamento;
    private Float deslocamentoEscavando;
    private Float deslocamentoEscalada;
    private Float deslocamentoVoo;
    private Float deslocamentoNado;
    private Integer forca;
    private Integer forcaModificador;
    private Integer destreza;
    private Integer destrezaModificador;
    private Integer constituicao;
    private Integer constituicaoModificador;
    private Integer inteligencia;
    private Integer inteligenciaModificador;
    private Integer sabedoria;
    private Integer sabedoriaModificador;
    private Integer carisma;
    private Integer carismaModificador;
    @ManyToOne
    @JoinColumn(name = "fkNivelDeDesafio")
    private NivelDeDesafio nivelDeDesafio;
    @ManyToOne
    @JoinColumn(name = "fkBonusDeProficienciaPorND")
    private ProficienciaPorND proficienciaPorND;
    private String vulnerabilidades;
    private String resistenciasDano;
    private String imunidadesDano;
    private String imunidadesCondicao;
    private String sentidos;
    private String pericias;
    private String reacoes;
    private String equipamento;
    private String acoesLendarias;
    private String acoesDeCovil;
    private String efeitosRegionais;
    @JsonManagedReference
    @OneToMany(mappedBy = "criatura")
    private List<AcaoCriatura> acoesCriatura;
    @JsonManagedReference
    @OneToMany(mappedBy = "criatura")
    private List<TracoEspecial> tracosEspeciais;
    @JsonManagedReference
    @OneToMany(mappedBy = "criatura")
    private List<AcaoLendariaCriatura> acoesLendariasCriatura;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "criaturas_idiomas",
            joinColumns = @JoinColumn(name = "fkIdCriatura", referencedColumnName = "idCriatura"),
            inverseJoinColumns = @JoinColumn(name = "fkIdIdioma", referencedColumnName = "idIdioma"))
    private List<Idioma> idiomas;
}
