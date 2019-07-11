package co.nf.axesoft.instawithparseb4app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.nf.axesoft.instawithparseb4app.R;

public class LoginActivity extends AppCompatActivity {

    private TextView txtAbrirCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtAbrirCadastro = findViewById(R.id.txtCadastrar);
        txtAbrirCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCadastro();
            }
        });








    }
    public void abrirCadastro(){

        startActivity( new Intent(LoginActivity.this,CadastroActivity.class));

    }
}
