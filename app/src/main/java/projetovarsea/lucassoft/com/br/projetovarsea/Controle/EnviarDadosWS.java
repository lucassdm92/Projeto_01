package projetovarsea.lucassoft.com.br.projetovarsea.Controle;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS.IntegrationServices;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;
import projetovarsea.lucassoft.com.br.projetovarsea.util.Utilitarios;

/**
 * Created by Lucas on 11/06/2016.
 */
public class EnviarDadosWS {

    private IntegrationServices integrationServices;

    public void enviarDadosCampeonato(CampeonatoVO campeonatoVO, ProgressBar view, Fragment fragment, FragmentManager fragmentManager) throws JSONException {


        try {
            Object[] b = new Object[3];
            final JSONObject jsonObject = Utilitarios.createJasonObject(campeonatoVO);
            b[0]=jsonObject;
            integrationServices = new IntegrationServices(view,fragmentManager,fragment);
            integrationServices.execute(b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //  final Object[] b = new Object[2];
       // JSONObject jsonPai = new JSONObject("Campeonato");
       // jsonPai.put("Nome", campeonatoVO.getNomeCampeonato());
       // jsonPai.put("Descricao", campeonatoVO.getDescricacaoCampeonato());
       // jsonPai.put("QtdTempo", campeonatoVO.getQtdTempo());
       // jsonPai.put("QtdTime", campeonatoVO.getQtdTime());
       // jsonPai.put("VlrCamp", campeonatoVO.getVlrCampeonato());

     //   b[0]=jsonPai;

      //  integrationServices = (IntegrationServices) new IntegrationServices();
      //  integrationServices.execute(b);


    }
}
