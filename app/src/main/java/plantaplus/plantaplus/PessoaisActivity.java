package plantaplus.plantaplus;

/**
 * PessoaisActivity.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import plantaplus.plantaplus.model.Planta;
import plantaplus.plantaplus.model.PlantaAdapter;

public class PessoaisActivity extends AppCompatActivity implements AsyncResponse{

    private final String host = "192.168.43.76";
    String user;

    JSONObject jsonObject;
    JSONArray jsonArray;
    PlantaAdapter plantaAdapter;
    ListView listView;

    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação. Ela também faz a comunicação com o banco de dados, para
     * retornar informações pertinentes às plantas do usuário e suas informações.
     *
     * @author Rafael Beffart Paludo
     * @since 12/10/2017
     * */

    /**
     * Contém os comandos e funções que devem ser executados na inicialização da interface gráfica à
     * qual a classe está relacionada
     *
     * @param savedInstanceState:
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoais);

        user = getIntent().getExtras().getString("user");

        listView = (ListView) findViewById(R.id.listView);
        plantaAdapter = new PlantaAdapter(this, R.layout.row_layout);
        plantaAdapter.setUser(user);
        listView.setAdapter(plantaAdapter);

        listaJardimPessoal();
    }

    /**
     * Saída de todas as funções de comunicação com o banco de dados chamadas e executadas nesta
     * função.
     *
     * @param output: Resultado final da função, retornado pelo script PHP de comunicação com o
     *              banco de dados
     */
    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();
        try {
            jsonObject = new JSONObject(output);
            jsonArray = jsonObject.getJSONArray("server_response");

            // dados das plantas
            String plantaNomePop, plantaNomeCient;

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject JO = jsonArray.getJSONObject(i);

                // repetir para cada dado das plantas
                plantaNomePop = JO.getString("nomePopular");
                plantaNomeCient = JO.getString("nomeCientifico");

                Planta planta = new Planta(plantaNomePop, plantaNomeCient);
                plantaAdapter.add(planta);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lista o jardim pessoal do usuário que acessou o aplicativo
     */
    public void listaJardimPessoal() {
        try {
            HashMap postData = new HashMap();
            postData.put("txtUsername", user);

            PostResponseAsyncTask task = new PostResponseAsyncTask(
                    PessoaisActivity.this, postData, PessoaisActivity.this);

            System.out.println("LISTA DE FLORES NO JARDIM");
            task.execute("http://" + host + "/client/listOwnedPlants.php");
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }
}
