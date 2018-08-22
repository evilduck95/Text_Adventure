package com.textAdventure.Text_Adventure.Entity;

import com.textAdventure.Text_Adventure.Entity.NPC.Monster;

import java.util.List;

public class Player {

    // Inventory control.
    private List<Object> inventory;

    private int activeItem;

    private String name;

    private int health;
    private int mana;
    private int strength;

    private int intelligence;
    private int endurance;
    public Player(String name,
                  int strength,
                  int intelligence,
                  int endurance){
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.endurance = endurance;

    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    public int getEndurance() { return endurance; }
    public void setEndurance(int endurance) { this.endurance = endurance; }

    
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
