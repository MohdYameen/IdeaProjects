package com.yameen;

import java.util.concurrent.CompletableFuture;

public class SyncAsycnProgramming {

    public static String syncMethodToFetchWeather(){

        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return "result from sync weather service :  Sunny 25 degree Celsius";
    }

    public static CompletableFuture<Void> asyncMethodToFetchWeather(){

        CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);  // Simulate API delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result from async weather service : Sunny, 25°C";
        });

        return weatherFuture.thenAccept(data -> System.out.println("Received: " + data));
    }

    public static void main(String[] args) {

        System.out.println("Synchronous Call Starts....................");
        System.out.println("Fetching weather reports");
        String weatherData = syncMethodToFetchWeather();
        System.out.println("Received: " + weatherData);
        System.out.println("Continuing with other work...");
        System.out.println("Synchronous Call Ends....................");


        System.out.println("Asynchronous Call Starts....................");
        CompletableFuture<String> weatherFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);  // Simulate API delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Sunny, 25°C";
        });

        System.out.println("Doing other work while weather data loads...");

        // Wait for result and then print it
        weatherFuture.thenAccept(data -> System.out.println("Received: " + data));

        // Prevent main from exiting early
        weatherFuture.join();

        //one more example
        System.out.println("Another example of CompletableFuture...");

        CompletableFuture<Void> future = CompletableFuture.runAsync(()-> {
            System.out.println("Running Thread in +"+Thread.currentThread().getName());
            try{
                Thread.sleep(3000); //
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task is completed!!!");
        });

        System.out.println("Main Thread Continues.....");
        future.join();

    }
}
