package models;

import java.util.Calendar;

public class Token {
    private long creation;
    private int token;
    private UserSession userSession;

    public Token(User user){
        this.creation = Calendar.getInstance().getTimeInMillis();
        this.token = System.identityHashCode(this);
        this.userSession = new UserSession(user);
    }

    public long getCreation() {
        return creation;
    }

    public int getToken() {
        return token;
    }


    public UserSession getUserSession() {
        return userSession;
    }
}
