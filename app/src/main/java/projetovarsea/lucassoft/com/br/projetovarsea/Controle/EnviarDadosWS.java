package projetovarsea.lucassoft.com.br.projetovarsea.Controle;

import org.json.JSONException;
import org.json.JSONObject;

import projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS.IntegrationServices;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;

/**
 * Created by Lucas on 11/06/2016.
 */
public class EnviarDadosWS {

    private IntegrationServices integrationServices;

    public void enviarDadosCampeonato(CampeonatoVO campeonatoVO) throws JSONException {

        final Object[] b = new Object[2];
        JSONObject jsonPai = new JSONObject("Campeonato");
        jsonPai.put("Nome", campeonatoVO.getNomeCampeonato());
        jsonPai.put("Descricao", campeonatoVO.getDescricacaoCampeonato());
        jsonPai.put("QtdTempo", campeonatoVO.getQtdTempo());
        jsonPai.put("QtdTime", campeonatoVO.getQtdTime());
        jsonPai.put("VlrCamp", campeonatoVO.getVlrCampeonato());

        b[0]=jsonPai;

        integrationServices = (IntegrationServices) new IntegrationServices();
        integrationServices.execute(b);


    }
}
