package plantaplus.plantaplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by RafaelBP on 05/11/2017.
 */

public class HomeActivity extends AppCompatActivity{

    final String user = getIntent().getStringExtra("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button bPlantasPessoais = (Button) findViewById(R.id.bPlantasPessoais);
        final Button bBancoPlantas = (Button) findViewById(R.id.bBancoPlantas);

        bPlantasPessoais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(HomeActivity.this, PessoaisActivity.class);
                it.putExtra("user", user);
                startActivity(it);
            }
        });
    }
}
