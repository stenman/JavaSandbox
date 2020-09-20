package com.example.sandbox.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * A simple callable/future that simulates calling a third party vendor for
 * generating parcel numbers.
 */
public class CallableFutureExample { 

    // antingen skapa många callableTasks (List<Callable>)
    // eller skapa en enda callableTask, som anropas många gånger (for loop)
    
    static ParcelGenerator pg;

    public static void main(String args[]) {
        
        // vi har 150 parcels
        // vi vill först dela upp dessa parcels i grupper om 10
        // detta ger oss 15 grupper, med 10 parcels i varje
        // Alt. 1 : för varje grupp, skapa en callableTask --> anropa invokeAll() 
        // Alt. 2 : Loopa <antal grupper> ggr, för varje grupp --> anropa submit() 
        
        pg = new ParcelGenerator();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = () -> {
            return Thread.currentThread().getName() + ", parcelNo:" + pg.generateParcel();
        };

        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

}
