package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Please add documentation to this class
 */
public class StreamsExperiment {

    public static void main(String args[]) {
        printStyle();
        manipulateIntegers();
    }

    private static void printStyle() {
        List<Thing> things = new ArrayList<>(asList(new Thing(1, "a"), new Thing(2, "b"), new Thing(3, "c")));
        print(things);
    }

    private static void manipulateIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 5, 6);

        List<Integer> numbersToPrint =
                numbers.stream()
                        .filter(integer -> integer > 3)
                        .filter(integer -> integer % 2 == 0)
                        .map(integer -> integer * 2)
                        .collect(toList());
        System.out.println(numbersToPrint);
    }

    private static void print(List<Thing> list) {
        Consumer<Thing> printStyle = (Thing t) -> System.out.println("id:" + t.getId() + ", Name:" + t.getName());
        list.forEach(printStyle);
    }


}
