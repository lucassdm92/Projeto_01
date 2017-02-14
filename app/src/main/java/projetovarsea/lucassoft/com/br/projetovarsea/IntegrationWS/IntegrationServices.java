package projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import projetovarsea.lucassoft.com.br.projetovarsea.R;
import projetovarsea.lucassoft.com.br.projetovarsea.fragment_cadastro_campeonatos;

import static android.R.attr.fragment;

/**
 * Created by Lucas on 21/05/2016.
 */
public class IntegrationServices extends AsyncTask {

    private static final String POST_URL_CAMPEONATOS = "http://10.0.2.2:8080/wspedalada/rest/wsServicesIntegration/create";
    private static final String POST_URL_TEAM = "http://10.0.2.2:8080/wspedalada/rest/wsServicesIntegration/createTeam";
    private ProgressBar progressBar;
    private FragmentManager fragmentManager;
    private Fragment fragmentd;
    private String urlWS;
    private Map<?,?> context;

    public IntegrationServices(final ProgressBar progressBar, FragmentManager fragment, Fragment fragmentd, String urlWS){
        this.progressBar  = progressBar;
        this.fragmentManager = fragment;
        this.fragmentd = fragmentd;
        this.urlWS = urlWS;
    }

    public IntegrationServices(final Map<?,?> context, final String urlWS){
        this.context = context;
        this.urlWS = urlWS;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        InputStream inStream =     this.getConection((JSONObject) params[0]);
        return "K";
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        this.progressBar = (ProgressBar) this.context.get("PROGRESS_BAR");
        this.fragmentd = (Fragment) this.context.get("FRAGMENT");
        this.fragmentManager = (FragmentManager) this.context.get("FRAGMENT_MANAGER");
        this.progressBar.setVisibility(View.INVISIBLE);
        this.progressBar.setVisibility(View.INVISIBLE);
        this.fragmentManager.beginTransaction().remove(this.fragmentd).commit();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressBar = (ProgressBar) this.context.get("PROGRESS_BAR");
        this.progressBar.setVisibility(View.VISIBLE);
    }

    private InputStream getConection(JSONObject valor){
        URL url = null;
        HttpURLConnection urlConnection = null;
        InputStream in = null;

        try {

            url = new URL(this.urlWS);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("accept","application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=utf8");
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout (90000) ;

       /*     if(!(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)){
                Log.d("Erro","Ocorreu um erro");
            }*/
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(valor.toString());
            out.close();

            BufferedReader bfin = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            bfin.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return in;
    }
}
