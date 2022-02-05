package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Please add documentation to this class
 */
public class StreamsExperiment {

    public static void main(String args[]) {
        // printStyle();
        // manipulateIntegers();
        listOfmapOfStringAndObjectToListOfStuff();
    }

    private static void listOfmapOfStringAndObjectToListOfStuff() {
        // List<Map<String, Object>>
        // [
        // {
        // "id": 1,
        // "name": "kalle"
        // },
        // {
        // "id": 2,
        // "name": "olle"
        // }
        // ]
        Map<String, Object> stuff1 = new HashMap<>();
        Map<String, Object> stuff2 = new HashMap<>();
        List<Map<String, Object>> stuffs = new ArrayList<>();

        stuff1.put("id", 1);
        stuff1.put("name", "Kalle");
        stuff2.put("id", 2);
        stuff2.put("name", "Olle");
        stuffs.addAll(asList(stuff1, stuff2));
        System.out.println(stuffs);

        // Gör om detta till en lista av Thing
        List<Thing> things = new ArrayList<>();

        things = stuffs.stream().map(d -> new Thing((int) d.get("id"), (String) d.get("name"))).collect(toList());

        System.out.println(things);
    }

    private static void printStyle() {
        List<Thing> things = new ArrayList<>(asList(new Thing(1, "a"), new Thing(2, "b"), new Thing(3, "c")));
        print(things);
    }

    private static void manipulateIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 5, 6);

        List<Integer> numbersToPrint = numbers.stream()
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
