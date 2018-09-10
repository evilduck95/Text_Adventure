package com.textAdventure.Text_Adventure.Entity.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class World {

    private List<List<Integer>> worldMap;

    String worldName;

    public void importWorld(String fileName) {

        /* File Name Fixing */

        if(!fileName.contains(".csv")){
            fileName.concat(".csv");
        }
        if (!fileName.contains("world/")) {
            fileName = String.join("world/", fileName);
        }
        // World Name without all the crap around it.
        this.worldName = fileName.substring(14, fileName.length() - 4);

        /* File Importing */

        // List for the world!
        List<List<Integer>> worldCells = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        // I can barely contain my files!
        File worldFile = new File(classLoader.getResource(fileName).getFile());

        Scanner inputStream;

        // At least we're trying!
        try {
            inputStream = new Scanner(worldFile);

            while(inputStream.hasNext()){

                // Get next line and split each element by a comma.
                String line = inputStream.next();
                String[] rowOfCellsStrings = line.split(",");

                // Convert Strings to ints.
                int[] rowOfCells = Arrays.stream(rowOfCellsStrings).mapToInt(Integer::parseInt).toArray();

                worldCells.add(Arrays.stream(rowOfCells)    // Stream rowOfCells,
                        .boxed()                            // Box each 'int' as an 'Integer' Object,
                        .collect(Collectors.toList()        // Collect 'Integer' Objects as List.
                        ));

            }
            // Close input stream.
            inputStream.close();

            this.worldMap = worldCells;

        } catch (FileNotFoundException e) {
            // File not found.
            System.out.println(String.format("FileNotFoundException when attempting to read %s.", fileName));
        } catch (Exception e) {
            e.printStackTrace();    // What could POSSIBLY have gone wrong?
        }



    }

    public void printWorld(){

        System.out.println(String.format("World Name: %s\n", this.worldName));

        // Much nicer to look at than a for loop!
        this.worldMap.forEach(row -> {
            row.forEach(cell -> System.out.print(String.format("%d | ", cell)));
            System.out.println("\n----------------------------------------");
        });

    }

    public String getCellType(int x, int y){

        // Get the integer at the specified index and return the corresponding World Type (row, col).
        int cellNumber = this.worldMap.get(y).get(x);
        return WorldCells.values()[cellNumber].toString();

    }

}
