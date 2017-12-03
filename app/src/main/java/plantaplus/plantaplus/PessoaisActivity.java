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
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PessoaisActivity extends AppCompatActivity implements AsyncResponse{

    final String user = getIntent().getExtras().getString("user");
    JSONObject jsonObject;
    JSONArray jsonArray;

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

        listaJardimPessoal();
    }

    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();
        try {
            jsonObject = new JSONObject(output);
            jsonArray = jsonObject.getJSONArray("server_response");

            // dados das plantas
            String plantData;

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject JO = jsonArray.getJSONObject(i);

                // repetir para cada dado das plantas
                plantData = JO.getString("tag");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void listaJardimPessoal() {
        try {
            HashMap postData = new HashMap();
            postData.put("txtUsername", user);

            PostResponseAsyncTask task = new PostResponseAsyncTask(
                    PessoaisActivity.this, postData, PessoaisActivity.this);

            System.out.println("LISTA DE FLORES NO JARDIM");
            task.execute("http://192.168.15.4/client/listOwnedPlants.php");
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }
}
