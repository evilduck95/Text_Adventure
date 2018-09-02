package com.textAdventure.Text_Adventure.Entity.Character;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Attribute {


    @NotNull @Max(value = 100, message = "Attribute Value Cannot Exceed 100") private int value;
    @NotNull private int incrementFactor;
    @NotNull(message = "Attribute Must Have Name") private final String name;
    @NotNull private final String type;

    // Fully Specified Dynamic Attribute.
    public Attribute(int value, String name, int incrementFactor) {
        this.value = value;
        this.name = name;
        this.incrementFactor = incrementFactor;
        this.type = "DYNAMIC_STAT";
    }

    // Fully Specified Static Attriute
    public Attribute(String name, int value) {
        this.name = name;
        this.value = value;
        this.incrementFactor = 1;
        this.type = "STATIC_STAT";
    }

    // Dynamic Stat, default to 100 if not specified.
    public Attribute(String name) {
        this.name = name;
        // Default to 100.
        this.value = 100;
        this.type = "DYNAMIC_STAT";
    }

    /* Add Recovery Factor to Value */
    public void increment() { this.value += this.incrementFactor; }

    public void setIncrementFactor(int incrementFactor) { this.incrementFactor = incrementFactor; }

    public int getValue() { return value; }

    public String getName() { return name; }
    public String getType() { return type; }
}
