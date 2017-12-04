package plantaplus.plantaplus.model;

/**
 * PlantaAdapter.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

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
import plantaplus.plantaplus.InformacaoDetalhadaActivity;
import plantaplus.plantaplus.R;

public class PlantaAdapter extends ArrayAdapter{

    /**
     * Essa classe tem como função servir como adaptador do objeto JSON retornado pelo script php, para
     * popular o ListView que é a lista de plantas, tanto do banco de plantas quanto do jardim pessoal
     *
     * @author Rafael Beffart Paludo
     * @since 28/11/2017
     * */

    List plantList = new ArrayList();
    String user;

    /**
     * Construtor de objeto Adapter
     *
     * @param context: Contexto no qual o Adapter será usado
     * @param resource: Objeto que será manipulado pelo Adapter
     */
    public PlantaAdapter(@NonNull Context context, int resource) {

        super(context, resource);
    }

    /**
     * Adiciona uma planta à lista de plantas do Adapter
     *
     * @param planta: Planta a ser adicionada
     */
    public void add(Planta planta) {
        super.add(planta);
        plantList.add(planta);
    }

    /**
     * Obtém o número de posições ocupadas na lista de plantas do Adapter
     *
     * @return Número de posições ocupadas na lista de plantas do Adapter
     */
    @Override
    public int getCount() {
        return plantList.size();
    }

    /**
     * Obtém um item (planta) da lista de plantas do Adapter
     *
     * @param position: Posição em que o item desejado se encontra
     * @return Item (planta) desejada, caso exista. Caso não exista, retorna null
     */
    @Nullable
    @Override
    public Object getItem(int position) {
        return plantList.get(position);
    }

    /**
     * Obtém a view gerada pelo Adapter
     *
     * @param position
     * @param convertView
     * @param parent
     * @return View gerada
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        final PlantHolder plantHolder;

        //if (row == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            plantHolder = new PlantHolder();
            plantHolder.popularNameText = (TextView) row.findViewById(R.id.textoNomePopular);
            plantHolder.scientificNameText = (TextView) row.findViewById(R.id.textoNomeCientifico);
            plantHolder.linha = (RelativeLayout) row.findViewById(R.id.linhaPlanta);
            row.setTag(plantHolder);
        //} else {
        //    plantHolder = (PlantHolder) row.getTag();
        //}

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

    /**
     * Envia a execução do aplicativo para a tela de informação detalhada da planta selecionada
     *
     * @param scientificName: Planta selecionada da lista de plantas
     */
    public void detalhesPlanta(String scientificName){
        Intent it = new Intent(this.getContext(), InformacaoDetalhadaActivity.class);
        it.putExtra("user", user);
        it.putExtra("planta", scientificName);
        this.getContext().startActivity(it);
    }

    /**
     * Setter da variável de usuário do Adapter, para envio como parâmetro para os scripts PHP
     *
     * @param user: Nome de usuário a ser atribuído à variável de usuário
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Classe para manipulação do layout que será gerado pelo Adapter
     */
    static class PlantHolder{
        TextView popularNameText;
        TextView scientificNameText;
        RelativeLayout linha;
    }
}
