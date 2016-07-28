package projetovarsea.lucassoft.com.br.projetovarsea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import projetovarsea.lucassoft.com.br.projetovarsea.VO.TimesVO;

/**
 * Created by ENGDB on 04/05/2016.
 */
public class CustomListAdapterTimes extends ArrayAdapter<TimesVO> {

    private Context context;

    public CustomListAdapterTimes(Context context, int resource, List<TimesVO> objects) {

        super(context, resource, objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimesVO venue =  getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_two,parent,false);
        }

        TextView text1 = (TextView) convertView.findViewById(R.id.txtNomeTime);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        TextView text2 = (TextView) convertView.findViewById(R.id.txtDescricaoTime);

        text1.setText(venue.getNomeTime());
        text2.setText(venue.getDescricaoTimes());


        return convertView;
    }
}
