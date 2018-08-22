package com.textAdventure.Text_Adventure.Entity.Item;

public class HealthPotion extends Potion {

    public HealthPotion(final int healthEffect, final int effectTurnLimit) {
        PotionBuilder healthPotionBuilder = new PotionBuilder().
                withHealthEffect(healthEffect).
                withEffectTurnLimit(effectTurnLimit);

    }

}
