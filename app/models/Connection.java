package models;


public class Connection {
    private int id;
    private String user;
    private String friend;

    public Connection(String user, String friend){
        this.id = System.identityHashCode(this);
        this.user = user;
        this.friend = friend;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getFriend() {
        return friend;
    }
}
