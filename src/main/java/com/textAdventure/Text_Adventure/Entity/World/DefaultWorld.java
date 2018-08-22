package com.textAdventure.Text_Adventure.Entity.World;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class DefaultWorld {

    private int[][] worldMap;

    String worldName;

    public void importWorld(String fileName) {
        if(!fileName.contains(".json")){
            fileName.concat("'json");
        }

        JSONParser jsonParser = new JSONParser();

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File worldFile = new File(classLoader.getResource(fileName).getFile());
            Object object = jsonParser.parse(new FileReader(worldFile));

            JSONObject jsonObject = (JSONObject) object;
            JSONArray worldMap = (JSONArray) jsonObject.get("worldMap");

            // TODO: Make JSON and check that file reading is working!


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
