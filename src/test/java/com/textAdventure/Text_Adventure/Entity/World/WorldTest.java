package com.textAdventure.Text_Adventure.Entity.World;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class WorldTest {

    private static final String TEST_WORLD_FILE = "static/worlds/testWorld.csv";

    // Test methods under normal operation. -->

    @Test
    void importWorld() {

        final World world = new World(worldMap, worldName);
        world.importWorld(TEST_WORLD_FILE);

        final String actual = world.worldName;
        final String expected = "testWorld";
        assertThat(actual, is(expected));
    }

    @Test
    void printWorld() {

        final World world = new World(worldMap, worldName);
        world.importWorld(TEST_WORLD_FILE);

        // Stream for grabbing console print-outs, save original.
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream originalStream = System.out;

        // Set for grabbing output, print then reset stream.
        System.setOut(new PrintStream(outputStream));
        world.printWorld();
        System.setOut(originalStream);

        // Expect SOut to contain the file-name.
        final String expected = "testWorld";
        assertThat(outputStream.toString(), containsString(expected));

    }

    @Test
    void getCellType() {

        final World world = new World(worldMap, worldName);
        world.importWorld(TEST_WORLD_FILE);

        // Get the cell type, it should return the enum value of that cell.
        final String actual = world.getCellType(0, 0);
        final String expected = "FIELD";
        assertThat(actual, is(expected));

    }

    // Test methods for failures.

}