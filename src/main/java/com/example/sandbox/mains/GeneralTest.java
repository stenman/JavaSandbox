package com.example.sandbox.mains;

import com.example.sandbox.stuff.Thing;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class GeneralTest {

    public static void main(String[] args) throws IOException {
//        for (int i = 1; i < 40; i++) {
//            System.out.println(i + ": " + faculty(i));
//        }
        System.out.println(faculty(BigInteger.valueOf(2)));
    }

    private static BigInteger faculty(BigInteger n) {
        if (n == BigInteger.ONE) {
            return BigInteger.ONE;
        } else {
            return (faculty(n.subtract(BigInteger.ONE)));
        }
    }
}
