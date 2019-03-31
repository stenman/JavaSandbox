package com.example.sandbox.patterns.strategy;

public class FireballAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("You hurl a magic fireball for 10 damage!");
    }
}
