package com.sda;

public interface IFighter {
    String getName();
    int getHp();

    AttackType getAttackAction();
    BlockType getBlockAction();

    void decreaseHp(int damage);
    boolean isAlive();

}
