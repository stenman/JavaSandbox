package com.example.sandbox.patterns.strategy;

public abstract class Character {

    AttackStrategy attackStrategy;
    DefenseStrategy defenseStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void setDefenseStrategy(DefenseStrategy defenseStrategy) {
        this.defenseStrategy = defenseStrategy;
    }

    public void walk() {
        System.out.println("You take a step forward.");
    }

    public abstract void display();

    public void attack() {
        attackStrategy.attack();
    }

    public void defend() {
        defenseStrategy.defend();
    }
}
