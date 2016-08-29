package models;

public class Share {
    private int id;
    private User user;
    private File file;

    public Share(User user, File file){
        this.id = System.identityHashCode(this);
        this.user = user;
        this.file = file;
    }


    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public File getFile() {
        return file;
    }
}
