package projetovarsea.lucassoft.com.br.projetovarsea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import projetovarsea.lucassoft.com.br.projetovarsea.Controle.EnviarDadosWS;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.TimesVO;

import static projetovarsea.lucassoft.com.br.projetovarsea.R.id.button4;
import static projetovarsea.lucassoft.com.br.projetovarsea.R.id.editText11;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CadastroTimes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CadastroTimes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroTimes extends Fragment  implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    private EditText txtNameTeam;
    private EditText txtDescribleTeam;
    private EditText txtQtdPlayer;
    private Button btnPersistence;

    private ProgressBar progressBar;
    private OnFragmentInteractionListener mListener;

    private Map<String,Object> mapFragment = new HashMap<>();
    public CadastroTimes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroTimes.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroTimes newInstance(String param1, String param2) {
        CadastroTimes fragment = new CadastroTimes();
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
        this.view =   inflater.inflate(R.layout.fragment_cadastro_times, container, false);

        this.txtNameTeam = (EditText) this.view.findViewById(R.id.editText10);
        this.txtDescribleTeam = (EditText) this.view.findViewById(R.id.editText11);
        this.btnPersistence = (Button) this.view.findViewById(R.id.button4);
        this.txtQtdPlayer = (EditText) this.view.findViewById(R.id.editText12);
        this.progressBar = (ProgressBar) this.view.findViewById(R.id.progressBar3);
        this.btnPersistence.setOnClickListener(this);


        return this.view;
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



    private Boolean validateFields(final EditText editText){
        if (TextUtils.isEmpty(editText.getText()))
            editText.setError("Tem que digitar");
        return TextUtils.isEmpty(editText.getText());
    }

    @Override
    public void onClick(View view) {
        if( this.validateFields(this.txtNameTeam)||
                this.validateFields(this.txtDescribleTeam)||
                this.validateFields(this.txtQtdPlayer)){
            return;
        }

        TimesVO timeVO = new TimesVO();

        timeVO.setNomeTime(this.txtNameTeam.getText().toString());
        timeVO.setDescricaoTimes(this.txtDescribleTeam.getText().toString());
        timeVO.setQtdPlayerTeam(Integer.parseInt(this.txtQtdPlayer.getText().toString()));
        EnviarDadosWS enviarDadosWS =  new EnviarDadosWS();

        /*mapFragment.put("CONTEXT",this.getContext());*/
        mapFragment.put("PROGRESS_BAR",this.progressBar);
        mapFragment.put("FRAGMENT",this);
        mapFragment.put("FRAGMENT_MANAGER",this.getFragmentManager());

        try {
            enviarDadosWS.enviarDadosTime(mapFragment,timeVO);
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
