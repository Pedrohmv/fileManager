package DAO.tables;

import models.File;
import models.Folder;

import java.util.ArrayList;
import java.util.List;

public class FileTable {
    private List<File> files;

    public FileTable(){
        files = new ArrayList();
    }

    public File getFile(Folder root, int id){
        for(File f : root.getFiles()){
            if(f.getId() == id)
                return f;
        }

        File auxFile = null;
        for(Folder f : root.getInFolder()){
            auxFile = getFile(f, id);
            if(auxFile != null && auxFile.getId() == id)
                return auxFile;
        }
        return auxFile;
    }
}
