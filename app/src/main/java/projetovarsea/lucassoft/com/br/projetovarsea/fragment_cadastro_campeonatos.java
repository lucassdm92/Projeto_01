package projetovarsea.lucassoft.com.br.projetovarsea;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;

import projetovarsea.lucassoft.com.br.projetovarsea.Controle.EnviarDadosWS;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_cadastro_campeonatos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_cadastro_campeonatos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_cadastro_campeonatos extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Fields
    private  EditText txtNameChampion;
    private  EditText txtDescChampion;
    private  EditText txtQtdTeam;
    private  EditText txtValorCampeonato;


    private View view;
    private ProgressBar progressBar;
    private OnFragmentInteractionListener mListener;

    public fragment_cadastro_campeonatos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_cadastro_campeonatos.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_cadastro_campeonatos newInstance(String param1, String param2) {
        fragment_cadastro_campeonatos fragment = new fragment_cadastro_campeonatos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view =   inflater.inflate(R.layout.fragment_fragment_cadastro_campeonatos, container, false);

        this.txtNameChampion = (EditText) view.findViewById(R.id.txtNameChampion);
        this.txtDescChampion = (EditText) view.findViewById(R.id.txtDescChampion);
        this.txtQtdTeam = (EditText) view.findViewById(R.id.txtQtdTeam);
        this.txtValorCampeonato = (EditText) view.findViewById(R.id.txtValorCampeonato);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);

        Button btDataSend = (Button) view.findViewById(R.id.button3);
        btDataSend.setOnClickListener(this);
        return view;
    }


    @Nullable
    private Boolean validateFields(final EditText editText){
        if (TextUtils.isEmpty(editText.getText()))
            editText.setError("Tem que digitar");
        return TextUtils.isEmpty(editText.getText());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        if( this.validateFields(this.txtNameChampion)||
            this.validateFields(this.txtDescChampion)||
            this.validateFields(this.txtQtdTeam)||
            this.validateFields(this.txtValorCampeonato)){
            return;
        }

        CampeonatoVO campeonatoVO = new CampeonatoVO();
        campeonatoVO.setNomeCampeonato(txtNameChampion.getText().toString());
        campeonatoVO.setDescricacaoCampeonato(txtNameChampion.getText().toString());
        campeonatoVO.setQtdTime(Short.parseShort(txtQtdTeam.getText().toString()));
        campeonatoVO.setVlrCampeonato(Double.parseDouble(txtValorCampeonato.getText().toString()));
        EnviarDadosWS enviarDadosWS = new EnviarDadosWS();
        try {

            enviarDadosWS.enviarDadosCampeonato(campeonatoVO, this.progressBar, this,this.getFragmentManager());
           ///Fecha Activi this.getFragmentManager().beginTransaction().remove(this).commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
