package com.example.sandbox.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * A simple class that simulates calling a third party vendor for
 * generating parcel numbers.
 * 
 * Generates many callables and invokes them all at the same time
 */
public class Caller2 {

    private ParcelGenerator pg = new ParcelGenerator();
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public List<String> generateParcels() {
        List<Future<String>> futures = new ArrayList<Future<String>>();

        List<Callable<String>> callables = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Callable<String> callable = () -> {
                return Thread.currentThread().getName() + ", C2-parcelNo:" + pg.generateParcel("C2");
            };
            callables.add(callable);
        }

        // Start executing!
        try {
            futures = executorService.invokeAll(callables);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        List<String> parcels = new ArrayList<>();

        // Wait for futures1
        for (Future<String> fut : futures) {
            try {
                parcels.add(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // We're done! Shut down!
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return parcels;
    }
}
