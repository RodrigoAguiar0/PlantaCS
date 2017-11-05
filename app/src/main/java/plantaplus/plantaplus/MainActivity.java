package plantaplus.plantaplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import plantaplus.plantaplus.model.Usuario;
import plantaplus.plantaplus.controller.UserDAO;
import plantaplus.plantaplus.controller.UserController;
import java.util.HashMap;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, AsyncResponse, View.OnClickListener{

    EditText etUsername;
    EditText etPassword;
  
    private final int RC_SIGN_IN = 9001;
    private final String TAG = "MainActivity";

    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final UserDAO userDAO = new UserDAO();
  
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
  
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final Button googleSignIn = (Button) findViewById(R.id.sign_in_button);
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
        HashMap postData = new HashMap();
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString() );

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://192.168.25.4/client/login.php");
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

    @Override
    public void processFinish(String output) {
        Toast.makeText(this, output, Toast.LENGTH_LONG).show();

        if (output == "success") {
            Intent it = new Intent(MainActivity.this, PlantaSelectionActivity.class);
            startActivity(it);
        }
    }
  
    public void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            Usuario usuario = new Usuario();
            UserController userControllerExample = new UserController();

            usuario.setNome(acct.getDisplayName());
            usuario.setEmail(acct.getEmail());
            
            userControllerExample.adicionar(usuario);
        }/* else {
            // Signed out, show unauthenticated UI.

        }*/
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
}
