package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Please add documentation to this class
 */
public class StreamsExperiment {

    public static void main(String args[]) {

        List<Thing> things = new ArrayList<>(asList(
                new Thing(1, "Kalle"),
                new Thing(2, "Bertil"),
                new Thing(3, "Nisse"),
                new Thing(4, "Bengt"),
                new Thing(5, "Sture"),
                new Thing(6, "Ture"),
                new Thing(7, "Olle")));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 5, 6);

        List<Integer> hej =
                numbers.stream()
                        .filter(integer -> integer > 3)
                        .filter(integer -> integer % 2 == 0)
                        .map(integer -> integer * 2)
                        .collect(toList());
//        System.out.println(hej);

//        List<Thing> hej2 =
//                things.stream()
//                        .forEach()
//                        .collect(Collectors.toList());

//        System.out.println((hej2.toString()));

    }


}
