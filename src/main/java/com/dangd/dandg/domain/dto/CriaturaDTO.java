package com.dangd.dandg.domain.dto;

import com.dangd.dandg.domain.classes.*;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class CriaturaDTO {
    private Integer idCriatura;
    private String nomeCriatura;
    private TipoDeCriatura tipoCriatura;
    private String tipoDeCriaturaExtra;
    private CategoriaDeTamanho categoriaDeTamanho;
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
    private NivelDeDesafio nivelDeDesafio;
    private ProficienciaPorND proficienciaPorND;
    private String vulnerabilidades;
    private String resistenciasDano;
    private String imunidadesDano;
    private String imunidadesCondicao;
    private String sentidos;
    private String idiomas;
    private String pericias;
    private String ataquesMultiplos;
    private String reacoes;
    private String equipamento;
    private String acoesLendarias;
    private String acoesDeCovil;
    private String efeitosRegionais;
    private List<AcaoCriatura> acoesCriatura;
    private List<TracoEspecial> tracosEspeciais;

    public static CriaturaDTO create(Criatura criatura){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(criatura, CriaturaDTO.class);
    }
}
