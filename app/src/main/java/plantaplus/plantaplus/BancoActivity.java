package plantaplus.plantaplus;

/**
 * BancoActivity.java
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


public class BancoActivity extends AppCompatActivity implements AsyncResponse {

    /**
     * Essa classe é responsável por manipular a interação do usuário com a aplicação através da
     * tela de banco de plantas
     *
     * @author Rafael Beffart Paludo
     * @since 3/12/2017
     * */

    private final String host = "192.168.43.76";

    JSONObject jsonObject;
    JSONArray jsonArray;
    PlantaAdapter plantaAdapter;
    ListView listView;

    String user;

    /**
     * Contém os comandos e funções que devem ser executados na inicialização da interface gráfica
     * do banco de plantas
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco);

        user = getIntent().getExtras().getString("user");

        listView = (ListView) findViewById(R.id.bancoListView);
        plantaAdapter = new PlantaAdapter(this, R.layout.row_layout);
        plantaAdapter.setUser(user);
        listView.setAdapter(plantaAdapter);

        listaJardimGlobal();
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
     * Realiza busca no banco de dados por meio de script PHP para obter as plantas registradas no
     * aplicativo
     */
    public void listaJardimGlobal() {
        try {
            HashMap postData = new HashMap();

            PostResponseAsyncTask task = new PostResponseAsyncTask(
                    BancoActivity.this, postData, BancoActivity.this);

            System.out.println("LISTA DE FLORES NO MUNDO");
            task.execute("http://" + host + "/client/listPlants.php");
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }
}
