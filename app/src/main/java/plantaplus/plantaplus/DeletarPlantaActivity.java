package plantaplus.plantaplus;

/**
 * DeletarPlantaActivity.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;


    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação, com a função de deletar uma planta pessoal.
     *
     * @author Rhenan Konrad
     * @since 30/11/2017
     * */

    /**
     * Contém os comandos e funções que devem ser executados na inicialização da interface gráfica à
     * qual a classe está relacionada
     *
     * @param savedInstanceState:
     */

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
