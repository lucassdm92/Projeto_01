package projetovarsea.lucassoft.com.br.projetovarsea.Controle;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

import projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS.IntegrationServices;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.TimesVO;
import projetovarsea.lucassoft.com.br.projetovarsea.util.Utilitarios;

/**
 * Created by Lucas on 11/06/2016.
 */
public class EnviarDadosWS {

    private IntegrationServices integrationServices;
    private static final String POST_URL_TEAM = "http://10.0.2.2:8080/wspedalada/rest/wsServicesIntegration/createTeam";

    public void enviarDadosCampeonato(CampeonatoVO campeonatoVO, ProgressBar view, Fragment fragment, FragmentManager fragmentManager) throws JSONException {


        try {
            Object[] b = new Object[3];
            final JSONObject jsonObject = Utilitarios.createJasonObject(campeonatoVO);
            b[0]=jsonObject;
         //   integrationServices = new IntegrationServices(view,fragmentManager,fragment);
          //  integrationServices.execute(b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void enviarDadosTime(Map<?,?> map, TimesVO timeVO) throws JSONException {
        try {
               Object[] b = new Object[3];
                final JSONObject jsonObject = Utilitarios.createJasonObject(timeVO);
                b[0]=jsonObject;
               integrationServices = new IntegrationServices(map,POST_URL_TEAM);
               integrationServices.execute(b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
