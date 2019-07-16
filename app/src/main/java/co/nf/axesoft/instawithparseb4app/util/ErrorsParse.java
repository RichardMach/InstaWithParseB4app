package co.nf.axesoft.instawithparseb4app.util;

import java.util.HashMap;

public class ErrorsParse {

    private HashMap<Integer,String> errosParse;

    public ErrorsParse(){
        this.errosParse = new HashMap<>();

        this.errosParse.put(205,"E-mail não cadastrado");
        this.errosParse.put(202,"usuário já cadastrado");
        this.errosParse.put(203,"email já cadastrado");

    }

    public String getErroParse(int codeError){

        return errosParse.get(codeError);

    }
}
