package DAO.tables;


import models.Token;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TokenTable {
    private List<Token> tokens;
    public TokenTable(){
        tokens = new ArrayList();
    }

    public Token search(int token){
        for (Token t : tokens) {
            if(token == t.getToken())
                return t;
        }

        return  null;
    }

    public void add(Token token){
        tokens.add(token);
    }

    public void remove(int token) {tokens.remove(search(token));}
    public void remove(Token token) {tokens.remove(token);}

    public Token getToken(int t){
        Token token = search(t);
        if(token != null){
            long now = Calendar.getInstance().getTimeInMillis();
            long interval = now - token.getCreation();
            if(interval < 0){
                remove(token);
                return  null;
            }
            return  token;
        }

        return null;

    }
}
