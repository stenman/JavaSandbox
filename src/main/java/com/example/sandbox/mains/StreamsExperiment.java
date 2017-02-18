package com.example.sandbox.mains;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Please add documentation to this class
 */
public class StreamsExperiment {

    public static void main(String args[]) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 4, 5, 6);

        List<Integer> hej =
                numbers.stream()
                        .filter(integer -> integer > 3)
                        .filter(integer -> integer % 2 == 0)
                        .map(integer -> integer * 2)
                        .collect(toList());
        System.out.println(hej);
    }


}
