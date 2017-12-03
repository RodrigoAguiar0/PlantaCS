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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DeletarPlantaActivity extends AppCompatActivity{

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
