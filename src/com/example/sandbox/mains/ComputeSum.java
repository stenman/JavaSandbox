package com.example.sandbox.mains;

import java.util.ArrayList;
import java.util.List;

public class ComputeSum {

	// Write three functions that
	// compute the sum of the numbers in a given list
	// using a for-loop, a while-loop, and recursion.

	private List<Integer> numbers = new ArrayList<Integer>();

	public void compute() {
		numbers.add(5);
		numbers.add(10);
		numbers.add(135);
		numbers.add(20);
		numbers.add(31);

		forLoop(numbers);
		whileLoop(numbers);
		recursion(numbers, numbers.size(), 0);
	}

	private void forLoop(List<Integer> numbers) {
		int sum = 0;
		for (Integer integer : numbers) {
			sum += integer;
		}
		System.out.println("for-loop sum = " + sum);
	}

	private void whileLoop(List<Integer> numbers) {
		int sum = 0;
		int loop = 0;
		while (loop < numbers.size()) {
			sum += numbers.get(loop);
			loop++;
		}
		System.out.println("while-loop sum = " + sum);
	}

	private int recursion(List<Integer> numbers, int size, int sum) {
		if (size == 0) {
			System.out.println("Recursion sum = " + sum);
			return sum;
		}
		size--;
		sum += numbers.get(size);
		return recursion(numbers, size, sum);
	}

}
