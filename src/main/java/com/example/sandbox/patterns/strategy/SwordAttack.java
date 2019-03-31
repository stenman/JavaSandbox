package com.example.sandbox.patterns.strategy;

public class SwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("You swing your sword for 5 damage!");
    }
}
