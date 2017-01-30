package projetovarsea.lucassoft.com.br.projetovarsea.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import projetovarsea.lucassoft.com.br.projetovarsea.Controle.EnviarDadosWS;
import projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS.IntegrationServices;
import projetovarsea.lucassoft.com.br.projetovarsea.R;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;

public class ActivityCampeonatos extends AppCompatActivity {

    private Button button;
    private IntegrationServices integrationServices;

    private TextView txtNomeCamp;
    private TextView txtDescricao;
    private EditText txtQtdTempo;
    private EditText txtVlrCampeonato;
    private CampeonatoVO campeonatoVO;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  integrationServices = new IntegrationServices(null,nul);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_campeonatos);

        txtNomeCamp = (TextView) this.findViewById(R.id.textView3);
        txtDescricao = (TextView) this.findViewById(R.id.editText2);

       txtQtdTempo = (EditText) this.findViewById(R.id.editText3);
       txtVlrCampeonato = (EditText) this.findViewById(R.id.editText5);


        button = (Button) this.findViewById(R.id.btnSalvarCamp);

        final Object[] b = new Object[2];

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    campeonatoVO = new CampeonatoVO();
                    campeonatoVO.setNomeCampeonato(txtNomeCamp.getText().toString());
                    campeonatoVO.setDescricacaoCampeonato(txtDescricao.getText().toString());
                    campeonatoVO.setQtdTempo(Short.parseShort(txtQtdTempo.getText().toString()));
                    campeonatoVO.setVlrCampeonato(Double.parseDouble(txtVlrCampeonato.getText().toString()));

                    EnviarDadosWS enviarDadosWS = new EnviarDadosWS();
                  //  enviarDadosWS.enviarDadosCampeonato(campeonatoVO,this.view);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ActivityCampeonatos Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
