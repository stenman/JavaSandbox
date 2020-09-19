package com.example.sandbox.mains;

import java.io.IOException;

public class MeasureObjectCreationTime {
    public static void main(String[] args) throws IOException {

        oneStringCreateEmpty();
        oneStringCreateWithText();
        manyStringCreateEmpty();
        manyStringCreateWithText();
    }

    private static void oneStringCreateEmpty() {
        long start = System.nanoTime();
        @SuppressWarnings("unused")
        String str = new String();
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Empty ONE\nTime elapsed: " + elapsedTime + "ns\n");
    }

    private static void oneStringCreateWithText() {
        long start = System.nanoTime();
        @SuppressWarnings("unused")
        String str = new String("some text");
        long elapsedTime = System.nanoTime() - start;
        System.out.println("With text ONE\nTime elapsed: " + elapsedTime + "ns\n");
    }

    private static void manyStringCreateEmpty() {
        long start = System.nanoTime();
        for (int i = 0; i < 3000000; i++) {
            @SuppressWarnings("unused")
            String str = new String();
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Empty MANY\nTime elapsed: " + elapsedTime / 1000000 + "ms\n");
    }

    private static void manyStringCreateWithText() {
        long start = System.nanoTime();
        for (int i = 0; i < 3000000; i++) {
            @SuppressWarnings("unused")
            String str = new String("some text");
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("With text MANY\nTime elapsed: " + elapsedTime / 1000000 + "ms");
    }

//	private static double calculateAverage(List<Long> marks) {
//		Long sum = 0L;
//		if (!marks.isEmpty()) {
//			for (Long mark : marks) {
//				sum += mark;
//			}
//			return sum.longValue() / marks.size();
//		}
//		return sum;
//	}

}
