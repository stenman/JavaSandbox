package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class GeneralTest {

    public static void main(String[] args) throws IOException {

//        List<Thing> list = asList(new Thing(1, "Mahesh"), new Thing(2, "Ram"), new Thing(3, "Krishna"));
//        list.add(new Thing(1, "Mahesh"));
//        list.add(new Thing(2, "Ram"));
//        list.add(new Thing(3, "Krishna"));
//        Consumer<Thing> style = (Thing p) -> System.out.println("id:"+p.getId() +", Name:"+p.getName());
//        System.out.println("---Before delete---\n"+list);
//        list.forEach(style);
//        Predicate<Thing> personPredicate = p-> p.getId() == 2;
//        list.removeIf(personPredicate);
//        System.out.println("---After delete---\n"+list);
//        list.forEach(style);

        List<Thing> things = new ArrayList<>(asList(new Thing(1, "a"), new Thing(2, "b"), new Thing(3, "c")));

        List<Thing> things1 = new ArrayList<>();
        Thing t1 = new Thing(1, "a");
        Thing t2 = new Thing(2, "b");
        Thing t3 = new Thing(3, "c");
        things1.addAll(asList(t1, t2, t3));

        Consumer<Thing> printStyle = (Thing t) -> System.out.println("id:" + t.getId() + ", Name:" + t.getName());

        System.out.println("---Before removal---");
        things.forEach(printStyle);
        things1.forEach(printStyle);

        Set<Integer> thingsToRemove = new HashSet<>();
        thingsToRemove.add(2);

        things.removeIf(t -> thingsToRemove.contains(t.getId()));
        things1.removeIf(t -> t.getId() == 2);

        System.out.println("---After removal---");
        things.forEach(printStyle);
        things1.forEach(printStyle);


    }
}
