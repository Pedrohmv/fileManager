package models;

public class File {
    private String name;
    private String content;
    private String typeOf;
    private int id;
    private String url;


    public File(String name, String typeOf){
        this.name = name;
        this.content = "";
        this.typeOf = typeOf;
        this.id = System.identityHashCode(this);
    }

    public File(String name,String typeOf, String content){
        this.name = name;
        this.content = content;
        this.typeOf = typeOf;
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

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }
}
