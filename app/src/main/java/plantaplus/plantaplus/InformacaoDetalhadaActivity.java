package plantaplus.plantaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformacaoDetalhadaActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_informacao_detalhada);

    final Button bDeletar = (Button) findViewById(R.id.bDeletar);

    bDeletar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent it = new Intent(InformacaoDetalhadaActivity.this, DeletarPlantaActivity.class);
            startActivity(it);
        }
    });
    }
}
