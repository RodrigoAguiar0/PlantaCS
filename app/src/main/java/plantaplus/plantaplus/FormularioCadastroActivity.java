package plantaplus.plantaplus;

/**
 * FormularioCadastroActivity.java
 * Versão: 0.8
 * Data de criação: 08/10/2017
 *
 * Este sistema tem o propósito de oferecer assistência para seus usuários, oferecendo recomendações
 * de cuidaddos, como rega, poda, adubação, tratamento de pragas e doenças e exposição ao sol, para
 * diversos tipos de plantas.
 * */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import plantaplus.plantaplus.controller.UserController;
import plantaplus.plantaplus.model.Usuario;

public class FormularioCadastroActivity extends AppCompatActivity {

    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação. Ela também faz a comunicação com o banco de dados, após
     * a passagem das requisições pelas classes Controller com as informações de cadastro.
     *
     * @author Rafael Beffart Paludo
     * @since 20/10/2017
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
        setContentView(R.layout.activity_formulario_cadastro);
    }

    /**
     * Captura todas as informações definidas pelo usuário e envia para que o controller faça a
     * adição
     */
    public void adicionar(){

        UserController userControler = new UserController();
        Usuario usuario = new Usuario();
        EditText nome = (EditText) findViewById(R.id.Nome);
        EditText email = (EditText) findViewById(R.id.Email);
        EditText senha = (EditText) findViewById(R.id.Senha);
        EditText  username = (EditText) findViewById(R.id.Username);

        usuario.setUsername(username.getText().toString());
        usuario.setNome(nome.getText().toString());
        usuario.setSenha(senha.getText().toString());
        usuario.setEmail(email.getText().toString());

        userControler.adicionarUsuario(usuario);
    }
}
