package com.textAdventure.Text_Adventure;

import com.textAdventure.Text_Adventure.Configuration.ExampleConfig;
import com.textAdventure.Text_Adventure.Entity.Character.Attribute;
import com.textAdventure.Text_Adventure.Entity.Utils.ClassValidator;
import com.textAdventure.Text_Adventure.Entity.World.World;

public class DriverApp {

    public static void main(String... args) {

        Attribute test = new Attribute(null, 101);
        ClassValidator.validate(test);

        World world = new World();
        world.importWorld("static/world/testWorld.csv");
        world.printWorld();

        for(int y = 0; y < 10; y++){ System.out.println(world.getCellType(0, y)); }

        System.out.println();

        ExampleConfig exampleConfig = new ExampleConfig();

    }
}
