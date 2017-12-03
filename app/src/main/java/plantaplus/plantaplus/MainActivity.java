package plantaplus.plantaplus;

/**
 * MainActivity.java
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

import plantaplus.plantaplus.controller.UserController;
import plantaplus.plantaplus.controller.UserDAO;
import plantaplus.plantaplus.model.Usuario;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, AsyncResponse{

    /**
     * Esta classe é responsável por fazer a interface entre a interface gráfica da aplicação e o
     * backend (parte lógica) da aplicação. Ela também faz a comunicação com o banco de dados, após
     * a passagem das requisições pelas classes Controller.
     *
     * @author Rodrigo Oliveira Gaíva Aguiar
     * @since 08/10/2017
     * */

    EditText etUsername;
    EditText etPassword;
    private UserController userController = new UserController();
    private UserDAO userDAO = new UserDAO();
    private Usuario usuario = new Usuario();

    private final int RC_SIGN_IN = 9001;
    private final String TAG = "MainActivity";

    private GoogleApiClient mGoogleApiClient;

    /**
     * Contém os comandos e funções que devem ser executados na inicialização da interface gráfica à
     * qual a classe está relacionada
     *
     * @param savedInstanceState:
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final SignInButton googleSignIn = (SignInButton) findViewById(R.id.sign_in_button);
        final Button bCadastro = (Button) findViewById(R.id.bCadastro);
      
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        bLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario.setUsername(etUsername.getText().toString());
                usuario.setSenha(etPassword.getText().toString());

                login();
            }
        });

        bCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, FormularioCadastroActivity.class);
                startActivity(it);
            }
        });

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                signIn();
            }
        });
    }

    /**
     * Saída de todas as funções de comunicação com o banco de dados chamadas e executadas nesta
     * função.
     *
     * @param output: Resultado final da função, retornado pelo script PHP de comunicação com o
     *              banco de dados
     */
    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();

        if (output.equals("success - login")) {
            Intent it = new Intent(MainActivity.this, HomeActivity.class);
            it.putExtra("user", etUsername.getText().toString());
            startActivity(it);
        } else if (output.contains("fail - Google login")) {
            System.out.println("FALHOU O LOGIN AQUI");
            cadastroGoogle(output.substring(22));
        }
    }

    /**
     * Inicia o processo de sign in (acesso) com conta Google à aplicação.
     */
    public void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    /**
     * Recebe o resultado retornado da tentativa de sign in (acesso) à aplicação com conta Google.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    /**
     * Trata o resultado da tentativa de sign in (acesso) com conta Google à aplicação,
     * encaminhando-o para o fluxo adequado.
     *
     * @param result: Resultado da tentativa de sign in com conta Google à aplicação,
     *              contendo, entre outros, informações da conta selecionada, para tratamento pela
     *              aplicação
     */
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            usuario.setEmail(acct.getEmail());
            usuario.setNome(acct.getDisplayName());

            loginGoogle(acct.getEmail());
        }/* else {
            // Signed out, show unauthenticated UI.

        }*/
    }

    /**
     * Trata a falha de conexão com serviços da Google.
     *
     * @param connectionResult: Resultado da tentativa de conexão com serviços da Google
     */
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    /**
     * Realiza o login à aplicação com conta Google.
     *
     * @param email: Informações do usuário que deseja fazer login na aplicação
     */
    public void loginGoogle(String email) {
        try {
            System.out.println("PASSEI PELO LOGIN");
            HashMap postData = new HashMap();
            postData.put("txtEmail", email);

            PostResponseAsyncTask task = new PostResponseAsyncTask(MainActivity.this, postData,
                    MainActivity.this);
            System.out.println("PASSEI PELO LOGIN com o email: " + email);
            task.execute("http://192.168.15.4/client/loginGoogle.php");
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }

    /**
     * Realiza o cadastro à aplicação com conta Google.
     *
     * @param email: Informações do usuário que deseja fazer cadastro na aplicação
     */
    public void cadastroGoogle(String email) {
        try {
            HashMap postData = new HashMap();
            postData.put("txtEmail", email);
            postData.put("txtName", email);

            PostResponseAsyncTask task = new PostResponseAsyncTask(MainActivity.this, postData,
                    MainActivity.this);
            System.out.println("PASSEI PELO CADASTRO");
            task.execute("http://192.168.15.4/client/registerGoogle.php");
        } catch (Exception e) {
            System.out.println("ALOOOOOOOOOU: " + e.getMessage());
        }
    }

    /**
     * Realiza o login à aplicaçao com conta comum.
     */
    public void login() {
            HashMap postData = new HashMap();
            postData.put("txtUsername", etUsername.getText().toString());
            postData.put("txtPassword", etPassword.getText().toString());

            PostResponseAsyncTask task = new PostResponseAsyncTask(MainActivity.this, postData,
                    MainActivity.this);
            task.execute("http://192.168.6.48/client/login.php");
    }
}
