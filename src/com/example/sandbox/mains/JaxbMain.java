package com.example.sandbox.mains;

import com.example.sandbox.stuff.Box;

public class JaxbMain {
    public static void main(String[] args) {
        Box box = new Box();
        String hello = box.doStuff("hej");
    }
}
