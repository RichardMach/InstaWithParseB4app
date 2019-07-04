package co.nf.axesoft.instawithparseb4app;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ParseStarter extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //Habilita o armazenamento local
        Parse.enableLocalDatastore(getApplicationContext());

        //Configuração do APP
        Parse.initialize( new Parse.Configuration.Builder(this)
        .applicationId("jiZGjqYG0oroRKpN9RUMYirJ9WdkCoBN")
        .clientKey(null)
        .server("http://insta020293.herokuapp.com/parse/")
        .build()
        );





        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
         defaultACL.setPublicReadAccess(true);
        //ParseACL.setDefaultACL(defaultACL, true);




    }
}
