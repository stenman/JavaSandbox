package com.example.sandbox.mains;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
	public static void main(String[] args) throws IOException {

		int max = 200000;

		int adjustTimeScale = 1000000;
		String timeScale = "ms";

		long startTime;
		long endTime;

		// FIRST, LAST, FIRST, LAST
		List<Integer> ll = createLinkedList(max, adjustTimeScale, timeScale);
		List<Integer> al = createArrayList(max, adjustTimeScale, timeScale);

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max / 2) {
				int num = (max - (i * 2 + 2));
				al.remove(0);
				al.remove(num);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - al.size()) + " elements (first, last, first, last, first, last...) from ArrayList in "
				+ (endTime - startTime) / adjustTimeScale + timeScale + ".");

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max / 2) {
				int num = (max - (i * 2 + 2));
				ll.remove(0);
				ll.remove(num);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - ll.size()) + " elements (first, last, first, last, first, last...) from LinkedList in "
				+ (endTime - startTime) / adjustTimeScale + timeScale + ".");

		// FIRST ELEMENT ONLY
		System.out.println("");
		ll = createLinkedList(max, adjustTimeScale, timeScale);
		al = createArrayList(max, adjustTimeScale, timeScale);

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max) {
				al.remove(0);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - al.size()) + " elements (first element only...) from ArrayList in " + (endTime - startTime)
				/ adjustTimeScale + timeScale + ".");

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max) {
				ll.remove(0);
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - ll.size()) + " elements (first element only...) from LinkedList in " + (endTime - startTime)
				/ adjustTimeScale + timeScale + ".");

		// LAST ELEMENT ONLY
		System.out.println("");
		ll = createLinkedList(max, adjustTimeScale, timeScale);
		al = createArrayList(max, adjustTimeScale, timeScale);

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max) {
				al.remove(max - (i + 1));
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - al.size()) + " elements (last element only...) from ArrayList in " + (endTime - startTime)
				/ adjustTimeScale + timeScale + ".");

		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			if (i < max) {
				ll.remove(max - (i + 1));
			}
		}
		endTime = System.nanoTime();
		System.out.println("Removed " + (max - ll.size()) + " elements (last element only...) from LinkedList in " + (endTime - startTime)
				/ adjustTimeScale + timeScale + ".");
	}

	private static List<Integer> createArrayList(int max, int adjustTimeScale, String timeScale) {
		long startTime;
		long endTime;
		List<Integer> al = new ArrayList<>();
		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			al.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("Initialized ArrayList in " + (endTime - startTime) / adjustTimeScale + timeScale + ".");
		return al;
	}

	private static List<Integer> createLinkedList(int max, int adjustTimeScale, String timeScale) {
		long startTime;
		long endTime;
		List<Integer> ll = new LinkedList<>();
		startTime = System.nanoTime();
		for (int i = 0; i < max; i++) {
			ll.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("Initialized LinkedList in " + (endTime - startTime) / adjustTimeScale + timeScale + ".");
		return ll;
	}

}
