package com.example.sandbox.concurrency;

import java.util.Random;

/**
 * A simple class that simulates creation of parcels
 */
public class ParcelGenerator {

    public String generateParcel() {
        int parcelno = new Random().nextInt(89999) + 10000;
        int sleepTime = new Random().nextInt(3000) + 2000;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "P" + parcelno;
    }

}
