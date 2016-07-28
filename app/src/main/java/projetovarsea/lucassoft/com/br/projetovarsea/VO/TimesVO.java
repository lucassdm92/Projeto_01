package projetovarsea.lucassoft.com.br.projetovarsea.VO;

import java.io.Serializable;

/**
 * Created by ENGDB on 04/05/2016.
 */
public class TimesVO implements Serializable {
    private Integer idTime;
    private String nomeTime;
    private String descricaoTimes;
    private String datainauguração;

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getDescricaoTimes() {
        return descricaoTimes;
    }

    public void setDescricaoTimes(String descricaoTimes) {
        this.descricaoTimes = descricaoTimes;
    }

    public String getDatainauguração() {
        return datainauguração;
    }

    public void setDatainauguração(String datainauguração) {
        this.datainauguração = datainauguração;
    }


}
