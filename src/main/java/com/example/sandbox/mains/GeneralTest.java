package com.example.sandbox.mains;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class GeneralTest {

    public static void main(String[] args) throws IOException {
        List<Integer> integersArray = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            integersArray.add(i);
            if (i % 1000000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Size: " + NumberFormat.getNumberInstance(Locale.US).format(integersArray.size()));
        System.out.println("Get element: " + integersArray.get(5000000));
        System.out.println("Now, let's try a linked list!");

        List<Integer> integersLinked = new LinkedList<>();

        for (int i = 0; i < 10000000; i++) {
            integersLinked.add(i);
            if (i % 1000000 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("Size: " + NumberFormat.getNumberInstance(Locale.US).format(integersLinked.size()));
        System.out.println("Get element: " + integersLinked.get(5000000));

    }
}
