package com.textAdventure.Text_Adventure.Entity.Character;

public class DefaultCharacter {

    private int health;

    private int strength;
    private int endurance;
    private int stamina;
    private int intelligence;

    public DefaultCharacter(int strength,
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
    //public void setStamina(int stamina) { this.stamina = stamina; }   //TODO: Might not need this.
    public void recoverStamina() { this.stamina += this.endurance; }    // This is probably better.

    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }




}
