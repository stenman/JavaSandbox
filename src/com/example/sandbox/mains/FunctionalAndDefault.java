package com.example.sandbox.mains;

@java.lang.FunctionalInterface
public interface FunctionalAndDefault extends ExtendMe {

    void doWork();

    default void doMoreWork() {
        System.out.println("I'm working even more in the FunctionalAndDefault interface!");
    }
}
