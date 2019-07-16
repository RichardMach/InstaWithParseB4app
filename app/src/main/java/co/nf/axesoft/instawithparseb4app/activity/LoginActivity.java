package co.nf.axesoft.instawithparseb4app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import co.nf.axesoft.instawithparseb4app.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtAbrirCadastro;
    private Button btnLogar;
    private EditText editUsername, editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verificaSessao();
            txtAbrirCadastro = findViewById(R.id.txtCadastrar);
            txtAbrirCadastro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    abrirCadastro();
                }
            });

            editUsername = findViewById(R.id.eTxtUserLogin);
            editPass = findViewById(R.id.eTxtPassLogin);
            btnLogar = findViewById(R.id.btnEntrarLogin);

            btnLogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = editUsername.getText().toString();
                    String password = editPass.getText().toString();
                    Toast.makeText(getApplicationContext(),password,Toast.LENGTH_LONG).show();
                    verificarLogin(user,password);
                }
            });







    }
    public void abrirCadastro(){

        startActivity( new Intent(LoginActivity.this,CadastroActivity.class));

    }
    private void abrirMain(){
        startActivity( new Intent(LoginActivity.this,MainActivity.class));
    }
    private void verificaSessao(){
        ParseUser parseUser = ParseUser.getCurrentUser();
        if (parseUser != null) {
            abrirMain();
            finish();

        }


    }

    private void verificarLogin(String username,String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {

                if (e==null && user != null) {
                    Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
                    abrirMain();
                }else if(user == null){
                    Toast.makeText(getApplicationContext(), "Senha inválida", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(),"Erro : "+e.getMessage()+"-"+e.getCode(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
