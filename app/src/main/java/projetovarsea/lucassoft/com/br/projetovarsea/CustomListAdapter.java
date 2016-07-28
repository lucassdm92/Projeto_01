package projetovarsea.lucassoft.com.br.projetovarsea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projetovarsea.lucassoft.com.br.projetovarsea.VO.CampeonatoVO;

/**
 * Created by Lucas on 03/05/2016.
 */
public class CustomListAdapter extends ArrayAdapter<CampeonatoVO> {

    private Context context;
    public CustomListAdapter(Context context, int resource, List<CampeonatoVO> objects) {
        super(context, resource, objects);
        this.context = context;  //
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CampeonatoVO venue =  getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_campeonato,parent,false);
        }

        TextView text1 = (TextView) convertView.findViewById(R.id.textView);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        TextView text2 = (TextView) convertView.findViewById(R.id.textView2);

        text1.setText(venue.getNomeCampeonato());
        text2.setText(venue.getDescricacaoCampeonato());


        return convertView;
    }
}
