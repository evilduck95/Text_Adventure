package com.textAdventure.Text_Adventure.Entity.Character;

import com.textAdventure.Text_Adventure.Entity.Character.Monster;

import java.util.List;

public class Player extends DefaultCharacter{

    // Inventory control.
    private List<Object> inventory;
    private int activeItem;

    private String name;

    public Player(String name,
                  int strength,
                  int intelligence,
                  int endurance){
        super(strength, endurance, intelligence);
        this.name = name;


    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setActiveItem(int activeItem) {
        this.activeItem = activeItem;
    }

    public Object getActiveItem() {
        return this.inventory.get(this.activeItem);
    }


    // Player can attack monsters.
    public void attack(Monster monster){

    }






}
