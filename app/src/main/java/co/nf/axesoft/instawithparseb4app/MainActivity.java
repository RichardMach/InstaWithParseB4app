package co.nf.axesoft.instawithparseb4app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       //Gravação
       ParseObject pontuacao = new ParseObject("Pontuacao");
        pontuacao.put("nome","Tuquinhas");
        pontuacao.put("pontos",500);
        pontuacao.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null){
                    Log.i("resut","Salvo com sucesso");
                }else {
                    Log.i("result","Erro al salvar");
                }

            }
        });

        //Recuperar e atualiza o registro
        ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");

        consulta.getInBackground("LkSITapbu3", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e==null){
                    object.put("pontos", 3000);
                    object.saveInBackground();
                }else{
                    Log.i("result","Erro ao consultar o objeto");
                }
            }
        });


    }
}
