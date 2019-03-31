package com.example.sandbox.patterns.strategy;

public class RpgMain {

    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();

        System.out.println("\nWizard time!");

        wizard.display();
        wizard.walk();
        wizard.attack();
        wizard.defend();
        wizard.setAttackStrategy(new IceLanceAttack());
        wizard.setDefenseStrategy(new MagicShieldDefense());
        wizard.attack();
        wizard.defend();

        System.out.println("\nNow, let the warrior show off!");

        warrior.display();
        warrior.walk();
        warrior.attack();
        warrior.defend();
    }
}