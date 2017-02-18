package com.example.sandbox.mains;

import com.example.sandbox.stuff.MultiTasker;

public class Threads {

	public static void main(String args[]) {

		MultiTasker mt = new MultiTasker();

		Thread t1 = new Thread(mt, "Rope");
		Thread t2 = new Thread(mt, "Cord");
		Thread t3 = new Thread(mt, "Wire");
		Thread t4 = new Thread(mt, "Lace");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("Hey look! I'm the main thread!");
	}

}
