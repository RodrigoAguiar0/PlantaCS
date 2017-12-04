package plantaplus.plantaplus;

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

/**
 * Created by RafaelBP on 03/12/2017.
 */

public class BancoActivity extends AppCompatActivity implements AsyncResponse {

    private final String host = "192.168.43.76";

    JSONObject jsonObject;
    JSONArray jsonArray;
    PlantaAdapter plantaAdapter;
    ListView listView;

    String user;

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
