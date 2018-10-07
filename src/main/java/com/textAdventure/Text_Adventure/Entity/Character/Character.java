package com.textAdventure.Text_Adventure.Entity.Character;

import javax.validation.constraints.Max;

public class Character {

    // Character Props
    @Max(100) private int health;
    @Max(100) private int stamina;
    // Character Stats
    @Max(10)  private int strength;
    @Max(10)  private int endurance;
    @Max(10)  private int intelligence;

    public Character(int strength,
                     int endurance,
                     int intelligence) {

        this.strength = strength;
        this.endurance = endurance;
        this.intelligence = intelligence;

        this.health = 100;
        this.stamina = 100;
    }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        if(health > 100) { this.health = 100; }
        else { this.health = health; }
    }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public int getEndurance() { return endurance; }
    public void setEndurance(int endurance) { this.endurance = endurance; }

    public int getStamina() { return stamina; }
    public void recoverStamina() { this.stamina += this.endurance; }

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }


}
