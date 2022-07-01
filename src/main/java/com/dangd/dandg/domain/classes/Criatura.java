package com.dangd.dandg.domain.classes;

import lombok.*;
import javax.persistence.*;

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
    private String idiomas;
    private String pericias;
    private String tracosEspeciais;
    private String acoes;
    private String ataquesMultiplos;
    private String reacoes;
    private String equipamento;
    private String acoesLendarias;
    private String acoesDeCovil;
    private String efeitosRegionais;
}
