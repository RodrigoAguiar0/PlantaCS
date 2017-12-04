package plantaplus.plantaplus;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class DeletarPlantaActivity extends AppCompatActivity implements AsyncResponse{

    private final String host = "192.168.43.76";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_planta);

        final Button bConfirmar = (Button) findViewById(R.id.bConfirmar);
        final Button bVoltar = (Button) findViewById(R.id.bVoltar);

        final String user = getIntent().getExtras().getString("user");
        final String planta = getIntent().getExtras().getString("planta");

        bConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    HashMap postData = new HashMap();
                    postData.put("txtUsername", user);
                    postData.put("txtNomeCientifico", planta);

                    PostResponseAsyncTask task = new PostResponseAsyncTask(
                            DeletarPlantaActivity.this, postData, DeletarPlantaActivity.this);

                    System.out.println("PASSEI PELA REMOCAO DE PLANTA");
                    task.execute("http://" + host + "/client/removePlant.php");
                } catch (Exception e) {
                    System.out.println("ALOOOOOOOOOU: " + e.getMessage());
                }
            }
        });

        bVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();
    }
}
