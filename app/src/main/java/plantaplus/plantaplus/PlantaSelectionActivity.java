package plantaplus.plantaplus;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlantaSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planta_selection);
    }

    public void trocaTela (View v) {
        Intent it = new Intent(PlantaSelectionActivity.this, InformacaoDetalhadaActivity.class);
        it.putExtra("Planta", v.getTag().toString());
        startActivity(it);
    }
}
