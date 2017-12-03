package plantaplus.plantaplus;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DeletarPlantaActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_planta);

        final Button bConfirmar = (Button) findViewById(R.id.bConfirmar);
        final Button bVoltar = (Button) findViewById(R.id.bVoltar);

        bConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //INSERIR AQUI CÓDICO PARA DELETAR PLANTA DO BANCO DE DADOS
            }
        });

        bVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(DeletarPlantaActivity.this, InformacaoDetalhadaActivity.class);
                startActivity(it);
            }
        });

    }

}
