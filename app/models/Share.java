package models;

public class Share {
    private int id;
    private String friend;
    private File file;

    public Share(String friend, File file){
        this.id = System.identityHashCode(this);
        this.friend = friend;
        this.file = file;
    }


    public int getId() {
        return id;
    }

    public String getFriend() {
        return friend;
    }

    public File getFile() {
        return file;
    }
}
