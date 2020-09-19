package com.example.sandbox.mains;

import com.example.sandbox.stuff.Animal;
import com.example.sandbox.stuff.Cat;

public class StackHeap {

    static int i = 0;

    public static void main(String[] args) {
        thisIsGoingOnTheStack();
        @SuppressWarnings("unused")
        double margarita = 2.0;
        System.out.println("Added a variable to the main method on the stack.");
        // TODO: implement this as a factory method
        @SuppressWarnings("unused")
        Animal a = new Cat();
        System.out.println("Added an object to the heap.");
        recursiveMadness();
        System.out.println("\n... can I haz continue? Well, of course! Next, let's destroy the heap!");
        destroyTheHeap();
    }

    private static void thisIsGoingOnTheStack() {
        @SuppressWarnings("unused")
        String onStack1 = "Yay! I'm on the stack!";
        @SuppressWarnings("unused")
        int onStack2 = 10101010;
        System.out.println("Added one method with two fields on the stack.");
    }

    private static void recursiveMadness() {
        try {
            i++;
            recursiveMadness();
        } catch (StackOverflowError e) {
            System.out.println("\nRecursive method calls before Stack Overflow: " + i);
        }
    }

    private static void destroyTheHeap() {
        int arraySize = 2;
        try {
            for (int i = 0; i < 99; i++) {
                @SuppressWarnings("unused")
                int[] memoryFiller = new int[arraySize];
                arraySize *= 2;
            }
        } catch (OutOfMemoryError e) {
            System.out.println(
                    "\nDestroyed the heap by overloading it with an int array with " + arraySize + " elements.");
            return;
        }
        System.out.println("\nCould not destroy the heap =( --> Please increase the array size!");
    }
}
