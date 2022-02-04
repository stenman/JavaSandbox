package com.example.sandbox.concurrency;

import java.util.ArrayList;
import java.util.Date;
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
 * Generates many futures and submits them one by one
 */
public class Caller1 {

    private ParcelGenerator pg = new ParcelGenerator();
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public List<String> generateParcels() {
        List<Future<String>> futures = new ArrayList<Future<String>>();

        Callable<String> callable = () -> {
            return Thread.currentThread().getName() + ", C1-parcelNo:" + pg.generateParcel("C1");
        };

        // Start executing!
        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(callable);
            futures.add(future);
        }

        List<String> parcels = new ArrayList<>();

        // Wait for futures
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
