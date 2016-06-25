package com.example.sandbox.mains;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	// Write a function that computes the list of the first 100 Fibonacci numbers.
	// By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.
	// As an example, here are the first 10 Fibonnaci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.

	public void fibonacci() {
		System.out.println(calculate(100));
	}

	private List<BigInteger> calculate(int num) {
		List<BigInteger> list = new ArrayList<>();
		list.add(new BigInteger("0"));
		BigInteger fibox = new BigInteger("0");
		BigInteger fibo1 = new BigInteger("0");
		BigInteger fibo2 = new BigInteger("1");
		for (int i = 0; i < num; i++) {
			if (i == 1) {
				fibo1 = BigInteger.valueOf(0);
			}
			fibox = fibo1.add(fibo2);
			fibo1 = fibo2;
			fibo2 = fibox;
			list.add(fibox);
		}
		return list;
	}

}
