package co.nf.axesoft.instawithparseb4app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.nf.axesoft.instawithparseb4app.R;

public class CadastroActivity extends AppCompatActivity {

    private TextView txtAbrirLogin;


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


    }
    public void abrirLogin(){
        startActivity( new Intent(CadastroActivity.this,LoginActivity.class));
    }
}
