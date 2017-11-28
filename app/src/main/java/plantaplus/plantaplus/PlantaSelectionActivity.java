package plantaplus.plantaplus;

/**
 * HomeActivity.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlantaSelectionActivity extends AppCompatActivity {

    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação. Ela também faz a comunicação com o banco de dados, para
     * registro de plantas selecionadas.
     *
     * @author Rodrigo Aguiar
     * @since 08/10/2017
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
        setContentView(R.layout.activity_planta_selection);
    }
}
