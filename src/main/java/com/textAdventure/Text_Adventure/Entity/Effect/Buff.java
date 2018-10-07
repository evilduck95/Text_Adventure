package com.textAdventure.Text_Adventure.Entity.Effect;

public class Buff {

    private int effectAmount;
    private String effectType;

    public Buff(final int effectAmount, final String effectType) {
        this.effectAmount = effectAmount;
        this.effectType = effectType;
    }

    public int getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(final int effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getEffectType() {
        return effectType;
    }

    public void setEffectType(final String effectType) {
        this.effectType = effectType;
    }



}
