package com.textAdventure.Text_Adventure.Entity.World;

import com.textAdventure.Text_Adventure.Utils.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class World {

    private final List<List<Integer>> worldMap;
    final String worldName;

    public World(String worldName) {
        String fixedFileName = "";
        if (!worldName.contains(".csv")) {
            fixedFileName = worldName.concat(".csv");
        }
        if (!worldName.contains("static/world/")) {
            fixedFileName = String.join("static/world/", worldName);
        }
        this.worldName = fixedFileName.substring(14, fixedFileName.length() - 4);

        List<List<Integer>> newWorldMap = null;
        try {
            newWorldMap = importWorld();
        } catch (Exception exc) {
            Logger.error(String.format("Issue loading world: %s", this.worldName), exc);
        }
        this.worldMap = newWorldMap;
    }

    private List<List<Integer>> importWorld() throws FileNotFoundException, Exception {

        List<List<Integer>> worldCells = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File worldFile = new File(classLoader.getResource(this.worldName).getFile());
        Scanner inputStream;

            inputStream = new Scanner(worldFile);
        while (inputStream.hasNext()) {
                String line = inputStream.next();
                String[] rowOfCellsStrings = line.split(",");

                int[] rowOfCells = Arrays.stream(rowOfCellsStrings).mapToInt(Integer::parseInt).toArray();
            worldCells.add(Arrays.stream(rowOfCells)
                    .boxed()
                    .collect(Collectors.toList()
                        ));

            }
            inputStream.close();
        return worldCells;
    }

    public void printWorld() {

        System.out.println(String.format("World Name: %s\n", this.worldName));

        this.worldMap.forEach(row -> {
            row.forEach(cell -> System.out.print(String.format("%d | ", cell)));
            System.out.println("\n----------------------------------------");
        });
        System.out.println();

    }

    public String getCellType(int x, int y) {
        int cellNumber = this.worldMap.get(y).get(x);
        return WorldCells.values()[cellNumber].toString();

    }

}
