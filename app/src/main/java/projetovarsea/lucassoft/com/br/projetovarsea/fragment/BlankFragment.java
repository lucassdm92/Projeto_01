package projetovarsea.lucassoft.com.br.projetovarsea.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import projetovarsea.lucassoft.com.br.projetovarsea.Activity.ActivityCampeonatos;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;
import projetovarsea.lucassoft.com.br.projetovarsea.CustomListAdapter;
import projetovarsea.lucassoft.com.br.projetovarsea.IntegrationWS.IntegrationServices;
import projetovarsea.lucassoft.com.br.projetovarsea.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements AbsListView.OnItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ListAdapter mAdapter;

    private ListView mListView;

    private CustomListAdapter customAdapterlist;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
   // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        CampeonatoVO campeonato = new CampeonatoVO();
        campeonato.setNomeCampeonato("Rachão Comunitario");
        campeonato.setDescricacaoCampeonato("Composto por 20 times, Rachão comunitario é um campeonato realizado no Jardim Angela com as equipes da região.");

        CampeonatoVO campeonato2 = new CampeonatoVO();
        campeonato2.setNomeCampeonato("Nakamura Champions League 2016");
        campeonato2.setDescricacaoCampeonato("Composto por 20 times e todos da região da Zona Sul, Champions League da oportunidade do time vencedor conquistar o Brasil.");


        CampeonatoVO campeonato3 = new CampeonatoVO();
        campeonato3.setNomeCampeonato("Brasil - Liga dos Campeões");
        campeonato3.setDescricacaoCampeonato("Composto por 10 times e todos do Brasil");
        List<CampeonatoVO> array = new ArrayList<CampeonatoVO>();
        array.add(campeonato);
        array.add(campeonato2);
        array.add(campeonato3);

        customAdapterlist = new CustomListAdapter(this.getActivity(),android.R.layout.simple_list_item_1,array);



     /*   try {
         String tetse = (String) integration.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/


/*
        FloatingActionButton fab = (FloatingActionButton) this.getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        mListView = (ListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(customAdapterlist);





        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent intente = new Intent(getActivity(),ActivityCampeonatos.class);
                startActivity(intente);


            }
        });


        final FloatingActionButton fab3 = (FloatingActionButton) view.findViewById(R.id.fab3);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                fab2.show();
                fab3.show();
            }




        });
        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fab2.hide();
                fab3.hide();

                return false;
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CampeonatoVO venue = customAdapterlist.getItem(position);
                Bundle bundle = new Bundle();
                // bundle.putSerializable("venue", (Serializable) venue.getListIamgem());
                bundle.putString("venue", venue.getNomeCampeonato());
               // startActivity(new Intent(getActivity(), ScrollingActivity.class).putExtras(bundle));
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
