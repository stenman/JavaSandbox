package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class GeneralTest {

    public static void main(String[] args) throws IOException {
        List<Thing> things = asList(new Thing(1, "a"), new Thing(2, "b"), new Thing(3, "c"));

        Set<Integer> thingsToRemove = new HashSet<>();
        thingsToRemove.add(2);

        things.removeIf(t -> thingsToRemove.contains(t.getId()));

        System.out.println(things);
        System.out.println(thingsToRemove);


    }
}
