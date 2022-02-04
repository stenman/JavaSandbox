package com.example.sandbox.concurrency;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * A simple callable/future that simulates calling a third party vendor for
 * generating parcel numbers.
 */
public class CallableFutureExample {

    public static void main(String args[]) {

        // vi har 150 parcels
        // vi vill först dela upp dessa parcels i grupper om 10
        // detta ger oss 15 grupper, med 10 parcels i varje
        // Alt. 1 : för varje grupp, skapa en callableTask --> anropa invokeAll()
        // Alt. 2 : Loopa <antal grupper> ggr, för varje grupp --> anropa submit()

        // notExecutedTasks = executorService.shutdownNow();
        //
        // for (int i = 0; i < notExecutedTasks.size(); i++) {
        // Runnable runnable = notExecutedTasks.get(i);
        // System.out.println("hej " + runnable.toString());
        // }

        Caller1 c1 = new Caller1();
        Caller2 c2 = new Caller2();
        List<String> parcels1 = c1.generateParcels();
        List<String> parcels2 = c2.generateParcels();

        for (String string : parcels1) {
            System.out.println(new Date() + ":: C1 ::" + string);
        }

        for (String string : parcels2) {
            System.out.println(new Date() + ":: C2 ::" + string);
        }

    }

}
