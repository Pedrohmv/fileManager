package models;


public class Connection {
    private int id;
    private User user1;
    private User user2;

    public Connection(User user1, User user2){
        this.id = System.identityHashCode(this);
        this.user1 = user1;
        this.user2 = user2;
    }

    public int getId() {
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }
}
