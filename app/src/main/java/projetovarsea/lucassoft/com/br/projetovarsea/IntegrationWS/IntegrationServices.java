package projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS;

import android.app.ProgressDialog;
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
    private ProgressBar progressBar;
    private FragmentManager fragment;
    private Fragment fragmentd;

    public IntegrationServices(final ProgressBar progressBar, FragmentManager fragment, Fragment fragmentd){
        this.progressBar  = progressBar;
        this.fragment = fragment;
        this.fragmentd = fragmentd;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        InputStream inStream =     this.getConection((JSONObject) params[0]);
        return "K";
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        this.progressBar.setVisibility(View.INVISIBLE);
        this.fragment.beginTransaction().remove(this.fragmentd).commit();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressBar.setVisibility(View.VISIBLE);
    }

    private InputStream getConection(JSONObject valor){
        URL url = null;
        HttpURLConnection urlConnection = null;
        InputStream in = null;

        try {

            url = new URL(POST_URL_CAMPEONATOS);
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

    /*private JSONObject parseObjeto(InputStream in){

        JSONObject c = null;

        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";

        try {
            while ((line = bf.readLine()) != null){
                stringBuffer.append(line);
            }


            c = new JSONObject(stringBuffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return c;

    }*/


}
