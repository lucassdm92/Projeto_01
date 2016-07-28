package projetovarsea.lucassoft.com.br.projetovarsea.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import projetovarsea.lucassoft.com.br.projetovarsea.CustomListAdapterTimes;
import projetovarsea.lucassoft.com.br.projetovarsea.R;
import projetovarsea.lucassoft.com.br.projetovarsea.VO.TimesVO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TwoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment implements AbsListView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    /***Custom***/

    private CustomListAdapterTimes customAdapterlist;
    private ListView mListView;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        TimesVO time1 = new TimesVO();
        time1.setNomeTime("JD Angela FC");
        time1.setDescricaoTimes("Time da Primeira divisão");

        TimesVO time2 = new TimesVO();
        time2.setNomeTime("Nakamura FC");
        time2.setDescricaoTimes("Time da Primeira divisão");


        TimesVO time3 = new TimesVO();
        time3.setNomeTime("Assoc. Pé de Pano");
        time3.setDescricaoTimes("Time da Primeira divisão");


        TimesVO time4 = new TimesVO();
        time4.setNomeTime("Capela Futebol Soccer");
        time4.setDescricaoTimes("Time da Primeira divisão");


        TimesVO time5 = new TimesVO();
        time5.setNomeTime("Varsea M Boi Mirim FC");
        time5.setDescricaoTimes("Time da Primeira divisão");


        TimesVO time6 = new TimesVO();
        time6.setNomeTime("Cachaça FC");
        time6.setDescricaoTimes("Time da Primeira divisão");
        List<TimesVO> listaTime = new ArrayList<TimesVO>() ;
        listaTime.add(time1);
        listaTime.add(time2);
        listaTime.add(time3);
        listaTime.add(time4);
        listaTime.add(time5);
        listaTime.add(time6);

        customAdapterlist = new CustomListAdapterTimes(this.getActivity(),android.R.layout.simple_list_item_1,listaTime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        mListView = (ListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(customAdapterlist);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimesVO venue = customAdapterlist.getItem(position);
                Bundle bundle = new Bundle();
                // bundle.putSerializable("venue", (Serializable) venue.getListIamgem());
                bundle.putString("venue", venue.getNomeTime());
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
