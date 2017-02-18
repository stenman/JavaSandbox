package com.example.sandbox.mains;

import com.example.sandbox.stuff.GenericsBox;

public class GenericsMain {
    public static void main(String[] args) {
        GenericsBox genericsBox = new GenericsBox();
        String someString = genericsBox.doStuff("Hello");
        System.out.println(someString);
        int someInteger = genericsBox.doStuff(1);
        System.out.println(someInteger);
    }
}
