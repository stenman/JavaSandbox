package com.example.sandbox.mains;

import java.util.ArrayList;
import java.util.List;

public class CombineLists {
    // Write a function that combines two lists by alternatingly taking elements.
    // For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].

    private List<Object> list1 = new ArrayList<Object>();
    private List<Object> list2 = new ArrayList<Object>();

    public void combine() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.add(1);
        list2.add(2);
        list2.add(3);
        List<Object> combined = combineLists(list1, list2);
        System.out.println(combined);
    }

    private List<Object> combineLists(List<Object> list1, List<Object> list2) {
        List<Object> combined = new ArrayList<Object>();
        for (int i = 0; i < list1.size(); i++) {
            combined.add(list1.get(i));
            combined.add(list2.get(i));
        }
        return combined;
    }
}
