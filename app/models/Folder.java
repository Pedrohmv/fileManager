package models;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Folder> inFolder;
    private int id;
    private List<File> files;
    private int count = 0;

    public Folder(String name){
        this.name = name;
        this.id = System.identityHashCode(this);
        this.inFolder = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getInFolder() {
        return inFolder;
    }

    public void setInFolder(List<Folder> inFolder) {
        this.inFolder = inFolder;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
