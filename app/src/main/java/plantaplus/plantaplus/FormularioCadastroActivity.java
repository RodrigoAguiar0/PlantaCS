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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

import plantaplus.plantaplus.controller.UserController;
import plantaplus.plantaplus.model.Usuario;

public class FormularioCadastroActivity extends AppCompatActivity implements AsyncResponse{

    EditText nome;
    EditText email;
    EditText senha;
    EditText username;

    private Usuario usuario = new Usuario();
    private UserController userControler = new UserController();

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

        nome = (EditText) findViewById(R.id.Nome);
        email = (EditText) findViewById(R.id.Email);
        senha = (EditText) findViewById(R.id.Senha);
        username = (EditText) findViewById(R.id.Username);
        Button bCadastro = (Button) findViewById(R.id.Cadastrar);

        bCadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                usuario.setNome(nome.getText().toString());
                usuario.setUsername(username.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());

                adicionar(usuario);
            }
        });
    }

     /**
     * Captura todas as informações definidas pelo usuário e envia para que o controller faça a
     * adição
     */
    public void adicionar (Usuario usuario){

        if (userControler.adicionarUsuario(usuario)) {
            try {
                HashMap postData = new HashMap();
                postData.put("txtUsername", usuario.getUsername());
                postData.put("txtPassword", usuario.getSenha());
                postData.put("txtEmail", usuario.getEmail());
                postData.put("txtName", usuario.getNome());
              
                PostResponseAsyncTask task = new PostResponseAsyncTask(
                        FormularioCadastroActivity.this, postData, FormularioCadastroActivity.this);

                System.out.println("PASSEI PELO CADASTRO COMUM");
                task.execute("http://192.168.15.4/client/register.php");
            } catch (Exception e) {
                System.out.println("ALOOOOOOOOOU: " + e.getMessage());
            }
        }
    }

    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();

        if (output.equals("success - cadastro")){
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Falha no cadastro: " + output, Toast.LENGTH_LONG).show();
        }
    }
}
