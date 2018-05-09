package com.sda;

import java.util.Random;

public class Boxer implements IFighter {


    private String name;
    private int hp;

    public Boxer(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public AttackType getAttackAction() {
        Random random = new Random();
        int attack = random.nextInt(100);
        if (attack >= 66) {
        return AttackType.HOOK;
        } else if (attack >= 33) {
            return AttackType.JAB;
        } else {
            return AttackType.UPPERCUT;
        }
    }

    @Override
    public BlockType getBlockAction() {
        Random random = new Random();
        int defense = random.nextInt(100);
        if (defense >= 66) {
            return BlockType.HIGH;
        } else if (defense >= 33) {
            return BlockType.LOW;
        } else {
            return BlockType.DODGE;
        }
    }

    @Override
    public void decreaseHp(int damage) {
        hp-=damage;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }
}
