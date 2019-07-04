package co.nf.axesoft.instawithparseb4app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       //Gravação
      /* ParseObject pontuacao = new ParseObject("Pontuacao");
        pontuacao.put("nome","Pugs");
        pontuacao.put("pontos",756);
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
        */

        //Recuperar e atualiza o registro
        /*ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");

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
        */


        ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");
        //filtro.whereGreaterThan("pontos",800);
        //filtro.whereGreaterThanOrEqualTo("pontos",1500);
        //filtro.whereLessThan("pontos",800);
        filtro.whereEndsWith("nome","a");
        //Listar os dados
        filtro.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    for(ParseObject parseObject : objects){
                        Log.i("listarDados","nome : "+ parseObject.get("nome")
                                +"| Pontos : " + parseObject.get("pontos") );
                    }

                }else{
                    Log.i("listarDados","Erro "+ e.getMessage());
                }

            }
        });

    }
}
