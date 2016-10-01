package DAO;

import DAO.tables.FileTable;
import DAO.tables.FolderTable;
import DAO.tables.TokenTable;
import DAO.tables.UserTable;

public class DataBase {
    private static DataBase dataBase;
    private UserTable users;
    private FolderTable folders;
    private FileTable files;
    private TokenTable tokens;

    private DataBase(){
        users = new UserTable();
        folders = new FolderTable();
        files = new FileTable();
        tokens = new TokenTable();
    }

    public static DataBase getDataBase(){
        if(dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }

    public UserTable getUsers(){
        return this.users;
    }

    public FolderTable getFolders(){
        return this.folders;
    }

    public FileTable getFiles(){
        return this.files;
    }

    public TokenTable getTokens(){
        return this.tokens;
    }
}
