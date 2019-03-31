package com.example.sandbox.patterns.strategy;

public class IceLanceAttack implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("You shoot a long lance of ice for 4 damage that also freezes the enemy!");
    }
}
