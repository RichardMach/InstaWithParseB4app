package co.nf.axesoft.instawithparseb4app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import co.nf.axesoft.instawithparseb4app.R;
import co.nf.axesoft.instawithparseb4app.util.ErrorsParse;

public class CadastroActivity extends AppCompatActivity {

    private TextView txtAbrirLogin,txtMsgErro;
    private EditText usernameETxt,emailETxt,passEtxt;
    private Button btnCadastrar;

    private ErrorsParse errorsParse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtAbrirLogin = findViewById(R.id.txtAbrirLogin);
        txtAbrirLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirLogin();
                finish();
            }
        });

        usernameETxt = findViewById(R.id.eTxtUserCadastro);
        emailETxt = findViewById(R.id.eTxtEmailCadastro);
        passEtxt = findViewById(R.id.eTxtPassCadastro);
        txtMsgErro = findViewById(R.id.txtMsgErro);
        btnCadastrar =findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });

    }
    public void abrirLogin(){
        startActivity( new Intent(CadastroActivity.this,LoginActivity.class));
    }
    private void cadastrarUsuario(){

        ParseUser parseUser = new ParseUser();

        parseUser.setUsername(usernameETxt.getText().toString());
        parseUser.setEmail(emailETxt.getText().toString());
        parseUser.setPassword(passEtxt.getText().toString());

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null){
                    Toast.makeText(getApplicationContext(),"Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
                    abrirLogin();
                }else{

                    if(e.getCode()==202){
                        usernameETxt.setTextColor(Color.RED);
                    }
                    errorsParse = new ErrorsParse();

                    String erro = errorsParse.getErroParse(e.getCode());
                    txtMsgErro.setText(erro);
                    Toast.makeText(getApplicationContext(),e.getCode() + erro,Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
