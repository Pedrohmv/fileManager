package DAO.tables;

import models.Folder;

import java.util.ArrayList;
import java.util.List;

public class FolderTable {
    private List<Folder> folders;

    public FolderTable(){
        folders = new ArrayList();
    }


    public Folder searchFolder(Folder root, int id) {
        if(root.getId() == id)
            return  root;
        else if(root.getInFolder().size() == 0)
            return null;

        for(Folder f : root.getInFolder()){
            if(f.getId() == id)
                return f;
        }

        Folder auxFolder = null;
        for(Folder f : root.getInFolder()){
            auxFolder = searchFolder(f, id);
            if(auxFolder != null && auxFolder.getId() == id)
                return auxFolder;
        }

        return auxFolder;
    }
}
