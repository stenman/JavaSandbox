package com.example.sandbox.patterns.strategy;

public class NoDefense implements DefenseStrategy {
    @Override
    public void defend() {
        System.out.println("Unfortunately you can't effectively defend yourself!");
    }
}
