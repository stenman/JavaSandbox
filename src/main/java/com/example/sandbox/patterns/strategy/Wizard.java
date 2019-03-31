package com.example.sandbox.patterns.strategy;

public class Wizard extends Character {
    public Wizard() {
        attackStrategy = new FireballAttack();
        defenseStrategy = new NoDefense();
    }

    @Override
    public void display() {
        System.out.println("The wizard, wielding his gnarled staff, ponders over the mysteries of the universe.");
    }
}
