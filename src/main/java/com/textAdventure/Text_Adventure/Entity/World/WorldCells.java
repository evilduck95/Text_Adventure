package com.textAdventure.Text_Adventure.Entity.World;

// TODO, ADD MORE CELL TYPES!
public enum WorldCells {

    FIELD("FIELD"),
    GARDEN("GARDEN"),
    FOREST("FOREST");

    private final String text;

    WorldCells(final String text){ this.text = text; }

    @Override
    public String toString() { return text; }

}
