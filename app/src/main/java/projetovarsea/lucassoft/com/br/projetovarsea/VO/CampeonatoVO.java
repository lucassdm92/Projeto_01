package projetovarsea.lucassoft.com.br.projetovarsea.VO;

import java.io.Serializable;

/**
 * Created by Lucas on 03/05/2016.
 */
public class CampeonatoVO implements Serializable {

    private Integer idCampeonato;

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }

    public void setNomeCampeonato(String nomeCampeonato) {
        this.nomeCampeonato = nomeCampeonato;
    }

    public String getDescricacaoCampeonato() {
        return descricacaoCampeonato;
    }

    public void setDescricacaoCampeonato(String descricacaoCampeonato) {
        this.descricacaoCampeonato = descricacaoCampeonato;
    }

    public Short getQtdTime() {
        return qtdTime;
    }

    public void setQtdTime(Short qtdTime) {
        this.qtdTime = qtdTime;
    }

    private String nomeCampeonato;

    public Double getVlrCampeonato() {
        return vlrCampeonato;
    }

    public void setVlrCampeonato(Double vlrCampeonato) {
        this.vlrCampeonato = vlrCampeonato;
    }

    public Short getQtdTempo() {
        return qtdTempo;
    }

    public void setQtdTempo(Short qtdTempo) {
        this.qtdTempo = qtdTempo;
    }

    private String descricacaoCampeonato;
    private Short qtdTime;
    private Short qtdTempo;
    private Double vlrCampeonato;
}
