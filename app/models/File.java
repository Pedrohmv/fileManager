package models;

public class File {
    private String name;
    private String content;
    private int id;
    private String url;
    private Share shared;


    public File(String name){
        this.name = name;
        this.content = "";
        this.id = System.identityHashCode(this);
        this.shared = new Share();
    }

    public File(String name, String content){
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Share getShared() {
        return shared;
    }
}
