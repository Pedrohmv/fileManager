package DAO.tables;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.User;
import play.libs.Json;

import java.io.*;


public class SuperTable {

    private String table;
    private ArrayNode node;
    private ObjectMapper mapper;

    public SuperTable(String table, ArrayNode node, ObjectMapper mapper){
        this.table = table;
        this.node = node;
        this.mapper = mapper;
    }

    protected ArrayNode updateBd(){
        try (FileWriter file = new FileWriter("./bd/" + this.table + ".json")) {
            BufferedWriter writerFile = new BufferedWriter(file);

            writerFile.write(this.node.toString());
            writerFile.close();
            this.node = loadUser();


        }catch (Exception e){
            e.printStackTrace();
        }

        return this.node;
    }


    protected ArrayNode loadUser(){
        this.node.removeAll();
        try (FileReader file = new FileReader("./bd/" + this.table + ".json")) {
            BufferedReader readFile = new BufferedReader(file);
            JsonNode json = this.mapper.readTree(readFile.readLine());

            for(JsonNode j: json)
                this.node.add(j);
            readFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.node;
    }

    protected JsonNode search( String field, String value){
        this.node = this.loadUser();
        for(int i = 0; i < this.node.size(); i++) {
            JsonNode user = this.node.get(0);
            if(user.get(field).asText().equals(value))
                return user;
        }
        return Json.toJson(new User("null", "null", "null"));
    }

    protected int searchIndex(String field, String value) {
        this.node = this.loadUser();
        for (int i = 0; i < this.node.size(); i++) {
            JsonNode user = this.node.get(0);
            if (user.get(field).asText().equals(value))
                return i;
        }
        return  -1;
    }
}
