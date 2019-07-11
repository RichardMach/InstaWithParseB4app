package co.nf.axesoft.instawithparseb4app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseSession;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

import co.nf.axesoft.instawithparseb4app.R;

public class MainActivity extends AppCompatActivity {


    private String nome,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome     = "Richard";
        password = "123456";
        email    = "michele.93@hotmail.com";

        /*=======================
        ***Cadastro de Usuário*/

        /*ParseUser parseUser = new ParseUser();
        parseUser.setUsername(nome);
        parseUser.setPassword(password);
        parseUser.setEmail(email);

        parseUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null) {
                    Log.i("cadastrado", "Cadsatrado com sucesso");
                }else{
                    Log.i("cadastrado","Erro ao cadastrar" + e.getMessage());
                }

            }
        });
       */

        //LOGOUT
       ParseUser.logOut();

        //VERIFICA A SESSÃO DO USUÁRIO
        if(ParseUser.getCurrentUser() == null){
           Log.i("usuario", "Não Logado");

        }else {
           Log.i("usuario", "Logado com sucesso");

        }


        /*ParseUser.logInInBackground(nome, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user!=null){
                    Log.i("usuario", "Logado com sucesso");
                }else{
                    Log.i("usuario", "Não Logado //" + e.getMessage());
                }

            }
        });
        */



    }
}
