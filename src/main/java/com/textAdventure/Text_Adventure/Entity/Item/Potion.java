package com.textAdventure.Text_Adventure.Entity.Item;

public class Potion {

    private int healthEffect;
    private int manaEffect;
    private int effectTurnLimit;

    public Potion(int healthEffect, int manaEffect, int effectTurnLimit) {
        this.healthEffect = healthEffect;
        this.manaEffect = manaEffect;
        this.effectTurnLimit = effectTurnLimit;
    }

    // Getters =>
    public int getHealthEffect() { return healthEffect; }

    public int getManaEffect() { return manaEffect; }

    public int getEffectTurnLimit() { return effectTurnLimit; }

    // Setters <=
    public void setHealthEffect(int healthEffect) { this.healthEffect = healthEffect;}

    public void setManaEffect(int manaEffect) { this.manaEffect = manaEffect; }

    public void setEffectTurnLimit(int effectTurnLimit) { this.effectTurnLimit = effectTurnLimit; }


    // Builder ==[]
    public static class PotionBuilder {

        private int healthEffect;
        private int manaEffect;
        private int effectTurnLimit;

        public PotionBuilder withHealthEffect(final int healthEffect) {
            this.healthEffect = healthEffect;
            return this;

        }

        public PotionBuilder withManaEffect(final int manaEffect) {
            this.manaEffect = manaEffect;
            return this;

        }

        public PotionBuilder withEffectTurnLimit(final int effectTurnLimit) {
            this.effectTurnLimit = effectTurnLimit;
            return this;
        }


        public Potion build() {
            return new Potion(this.healthEffect, this.manaEffect, this.effectTurnLimit);
        }


    }


}
