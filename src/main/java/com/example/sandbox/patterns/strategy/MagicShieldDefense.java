package com.example.sandbox.patterns.strategy;

public class MagicShieldDefense implements DefenseStrategy {
    @Override
    public void defend() {
        System.out.println("You create a magic barrier to deflect 7 damage!");
    }
}
