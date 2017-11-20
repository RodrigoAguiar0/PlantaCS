package plantaplus.plantaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import plantaplus.plantaplus.controller.UserController;
import plantaplus.plantaplus.model.Usuario;

public class FormularioCadastroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cadastro);
    }

    public void adicionar (){

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
