package com.sda;


public class App {
    public static void main(String[] args) {


        IFighter fighter1 = new Boxer("Andrzej Gołota", 20);
        IFighter fighter2 = new Boxer("Mike Tyson", 20);

        IFight fight = new BoxingMatch(fighter1, fighter2);
        fight.fight();

    }
}
