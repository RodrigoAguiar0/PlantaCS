package plantaplus.plantaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final Button bCadastro = (Button) findViewById(R.id.bCadastro);

        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent loginIntent = new Intent(MainActivity.this, PlantaSelectionActivity.class);
                MainActivity.this.startActivity(loginIntent);
            }
        });

        bCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, FormularioCadastroActivity.class);
                startActivity(it);
            }
        });
    }

    //public void realiza_cad(View view) {
    //    Toast.makeText(getApplicationContext(), "teste!!!", Toast.LENGTH_LONG).show();
    //}
}
