package com.example.sandbox.patterns.strategy;

public class Warrior extends Character {
    public Warrior() {
        attackStrategy = new SwordAttack();
        defenseStrategy = new ShieldDefense();
    }

    @Override
    public void display() {
        System.out.println("The mighty warrior, gripping his sword tight, is flexing his big muscles.");
    }
}
