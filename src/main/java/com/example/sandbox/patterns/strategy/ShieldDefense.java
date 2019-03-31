package com.example.sandbox.patterns.strategy;

public class ShieldDefense implements DefenseStrategy {
    @Override
    public void defend() {
        System.out.println("You put your shield up and deflect 5 damage!");
    }
}
