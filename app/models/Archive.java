package models;

public class Archive {
    private String name;
    private int id;
    private String url;


    public Archive(String name){
        this.name = name;
        this.id = System.identityHashCode(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
