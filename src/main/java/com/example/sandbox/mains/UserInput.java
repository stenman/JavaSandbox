package com.example.sandbox.mains;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) throws IOException {

		readInputWithBufferedReader();
		readInputWithScanner();
		System.out.println("\nEnd of program. Thank you for using Super Ultra Conversationist Professional. Now available for the price of only 599$!");
	}

	private static void readInputWithBufferedReader() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		System.out.print("Enter String:\n");
		String s = br.readLine();
		try {
			System.out.print("Enter Integer:\n");
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		System.out.println("readInputWithBufferedReader string: " + s);
		System.out.println("readInputWithBufferedReader integer: " + i);
	}

	private static void readInputWithScanner() {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter String:\n");
		String s = in.next();
		System.out.print("Enter Integer:\n");
		int i = in.nextInt();

		System.out.println("readInputWithScanner string: " + s);
		System.out.println("readInputWithScanner integer: " + i);
	}
}
