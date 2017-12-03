package plantaplus.plantaplus.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import plantaplus.plantaplus.MainActivity;
import plantaplus.plantaplus.R;

/**
 * Created by RafaelBP on 25/11/2017.
 */

public class PlantaAdapter extends ArrayAdapter{

    List plantList = new ArrayList();

    public PlantaAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void add(Planta planta) {
        super.add(planta);
        plantList.add(planta);
    }

    @Override
    public int getCount() {
        return plantList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return plantList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        final PlantHolder plantHolder;

        if (row == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            plantHolder = new PlantHolder();
            plantHolder.popularNameText = (TextView) row.findViewById(R.id.textoNomePopular);
            plantHolder.scientificNameText = (TextView) row.findViewById(R.id.textoNomeCientifico);
            row.setTag(plantHolder);
        } else {
            plantHolder = (PlantHolder) row.getTag();
        }

        Planta planta = (Planta) this.getItem(position);
        plantHolder.popularNameText.setText(planta.getNomePopular());
        plantHolder.scientificNameText.setText(planta.getNomeCientifico());
        plantHolder.linha.setTag(planta.getNomeCientifico());
        plantHolder.linha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detalhesPlanta(v.getTag().toString());
            }
        });
        return row;
    }

    public void detalhesPlanta(String scientificName){
        Intent it = new Intent(this.getContext(), /*trocar pela tela de detalhes da planta*/MainActivity.class);
        it.putExtra("planta", scientificName);
        this.getContext().startActivity(it);
    }

    static class PlantHolder{
        TextView popularNameText;
        TextView scientificNameText;
        RelativeLayout linha;
    }
}
