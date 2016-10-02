package DAO.tables;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.Folder;
import play.libs.Json;

public class FolderTable extends SuperTable{
    private static ObjectMapper mapper = new ObjectMapper();
    private static ArrayNode foldersNode = mapper.createArrayNode();

    public FolderTable(){
        super("folders", foldersNode, mapper);
    }

    public JsonNode get(int id){
        return search("id", Integer.toString(id));
    }

    public int createRoot(){
        Folder root = new Folder("Root");
        this.foldersNode.add(Json.toJson(root));
        return root.getId();
    }

    public void add(JsonNode folder){
        this.foldersNode.add(folder);
        super.updateBd();
    }

    public void addInFolder(JsonNode folder, int id){
        ArrayNode parentFolder = (ArrayNode) get(id);

        ArrayNode inFolder = mapper.createArrayNode();
        for(JsonNode j: parentFolder.get("inFolder")){
            inFolder.add(j);
        }
        inFolder.add(folder);

        parentFolder.

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
