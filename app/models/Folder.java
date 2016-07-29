package models;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Folder> inFolder;
    private String id;
    private List<Archive> files;

    public Folder(String name){
        this.name = name;
        this.inFolder = new ArrayList<>();
        this.files = new ArrayList<>();
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

    public List<Archive> getFiles() {
        return files;
    }

    public void setFiles(List<Archive> files) {
        this.files = files;
    }
}
