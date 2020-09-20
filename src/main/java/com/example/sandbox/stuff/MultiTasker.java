package com.example.sandbox.stuff;

import java.util.Random;

public class MultiTasker implements Runnable {

    @Override
    public void run() {
        Random r = new Random();

        int sleep;

        try {
            for (int i = 0; i < 10; i++) {
                sleep = r.nextInt(5000);
                Thread.sleep(sleep);
                System.out.println(
                        "Thread " + Thread.currentThread().getName() + " just slept for " + sleep + " seconds.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " is done!");
    }
}
