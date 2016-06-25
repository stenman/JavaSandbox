package com.example.sandbox.mains;


//A class demonstrating Functional Interfaces, Default Methods and Lambda Expressions
public class FunctionalAndDefaultWithLambdaMain implements FunctionalAndDefault {

    public static void main(String[] args) {
        FunctionalAndDefault fim = new FunctionalAndDefaultWithLambdaMain();
        fim.doWork();
        fim.doMoreWork();
    }

    @Override
    public void doWork() {
        System.out.println("I am working in main!");
    }
}
