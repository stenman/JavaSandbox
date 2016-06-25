package com.example.sandbox.mains;

//This class demonstrates how to implement a functional interface using lambda
public class LambdaFuncInterface {
    public static void main(String[] args) {

        //Without Lambda
        carryOutWork(new FunctionalAndDefault() {
            @Override
            public void doWork() {
                System.out.println("Overriding FAD");
            }
        });

        //With Lambda
        carryOutWork(() -> System.out.println("Implementing FAD using Lambda!"));
    }

    public static void carryOutWork(FunctionalAndDefault fad) {
        fad.doWork();
    }
}
