package plantaplus.plantaplus;

/**
 * InformacaoDetalhadaActivity.java
 * Versão: 0.8
 * Data de criação: 30/11/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação, com a função de apresentar informações detalhadas da
     * planta.
     *
     * @author Rhenan Konrad
     * @since 30/11/2017
     * */
public class InformacaoDetalhadaActivity extends AppCompatActivity implements AsyncResponse{

    private final String host = "192.168.43.76";
    private String user, planta;
    private Button bDeleteAdd;
    private TextView textNome, textNomeCient, textDescricao, textRega, textExpoSolar, textAdubagem,
            textPoda, textPragas, textDoencas;
    private ImageView imagePlanta;

    /**
     * Contém os comandos e funções que devem ser executados na inicialização da interface gráfica à
     * qual a classe está relacionada
     *
     * @param savedInstanceState:
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_detalhada);

        user = getIntent().getExtras().getString("user");
        planta = getIntent().getExtras().getString("planta");

        bDeleteAdd = (Button) findViewById(R.id.bDeleteAdd);
        textNome = (TextView) findViewById(R.id.nomePlanta);
        textNomeCient = (TextView) findViewById(R.id.nomeCientPlanta);
        textDescricao = (TextView) findViewById(R.id.descricaoPlanta);
        textRega = (TextView) findViewById(R.id.regaPlanta);
        textExpoSolar = (TextView) findViewById(R.id.expoSolarPlanta);
        textAdubagem = (TextView) findViewById(R.id.adubagemPlanta);
        textPoda = (TextView) findViewById(R.id.podaPlanta);
        textPragas = (TextView) findViewById(R.id.pragasPlanta);
        textDoencas = (TextView) findViewById(R.id.doencasPlanta);
        imagePlanta = (ImageView) findViewById(R.id.imagemPlanta);

        inicializaCampos();
    }

    public void inicializaCampos() {
        try {
            HashMap postData = new HashMap();

            postData.put("txtScientificName", planta);

            PostResponseAsyncTask task = new PostResponseAsyncTask(InformacaoDetalhadaActivity.this, postData,
                    InformacaoDetalhadaActivity.this);

            task.execute("http://" + host + "/client/plantDetails.php");

//            postData.put("txtUsername", user);

  //          task.execute("http://" + host + "/client/isOwnedBy.php");

        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }

    @Override
    public void processFinish(String output) {
        if (output.equals("own - true")) {
            // muda valor de botão para excluir planta
            bDeleteAdd.setText("Remover planta do jardim");
            bDeleteAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(InformacaoDetalhadaActivity.this, DeletarPlantaActivity.class);
                    it.putExtra("user", user);
                    it.putExtra("planta", planta);
                    startActivity(it);
                }
            });
        } else if (output.equals("own - false")) {
            // muda valor de botão para adicionar planta
            bDeleteAdd.setText("Adicionar planta ao jardim");
            bDeleteAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        HashMap postData = new HashMap();

                        postData.put("txtUsername", user);
                        postData.put("txtNomeCientifico", planta);

                        PostResponseAsyncTask task = new PostResponseAsyncTask(InformacaoDetalhadaActivity.this, postData,
                                InformacaoDetalhadaActivity.this);

                        task.execute("http://" + host + "/client/registerPlant.php");

                    } catch (Exception e) {
                        System.out.println("ALOOOOOOOOOU: " + e.getMessage());
                    }
                }
            });
        } else if (output.equals("success - jardim")) {
            System.out.println("Planta adicionada ao jardim com sucesso!");
        } else if (output.contains("fail - jardim")) {
            System.out.println("Falha na adição da planta ao jardim: " + output);
        } else {
            // preenche os views da tela
            JSONObject jsonObject;
            JSONArray jsonArray;
            Toast.makeText(this, output, Toast.LENGTH_LONG).show();

            try {
                jsonObject = new JSONObject(output);
                jsonArray = jsonObject.getJSONArray("server_response");
                jsonObject = jsonArray.getJSONObject(0);

                // dados das plantas
                String plantaNomePop, plantaNomeCient, plantaDesc, plantaRega, plantaExpoSolar, plantaAdubagem, plantaPoda, plantaPragas, plantaDoencas;

                // repetir para cada dado das plantas
                plantaNomeCient = jsonObject.getString("nomeCientifico");
                plantaNomePop = jsonObject.getString("nomePopular");
                plantaRega = jsonObject.getString("rega");
                plantaExpoSolar = jsonObject.getString("exposicaoSolar");
                plantaAdubagem = jsonObject.getString("adubagem");
                plantaPoda = jsonObject.getString("poda");
                plantaPragas = jsonObject.getString("pragas");
                plantaDoencas = jsonObject.getString("doencas");
                plantaDesc = jsonObject.getString("descricao");

                textNome.setText(plantaNomePop);
                textNomeCient.setText(plantaNomeCient);
                textDescricao.setText(plantaDesc);
                textRega.setText(plantaRega);
                textExpoSolar.setText(plantaExpoSolar);
                textAdubagem.setText(plantaAdubagem);
                textPoda.setText(plantaPoda);
                textPragas.setText(plantaPragas);
                textDoencas.setText(plantaDoencas);

                HashMap postData = new HashMap();

                postData.put("txtScientificName", planta);
                postData.put("txtUsername", user);

                PostResponseAsyncTask task = new PostResponseAsyncTask(InformacaoDetalhadaActivity.this, postData,
                        InformacaoDetalhadaActivity.this);

                task.execute("http://" + host + "/client/isOwnedBy.php");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
