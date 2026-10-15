package multithreading_concurrency.completable_future;

import java.util.concurrent.CompletableFuture;

public class Driver {
    public static void main(String[] args) {
        // CompletableFuture is used to perform async operations
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return 20;
        }).thenApplyAsync((n) -> 
        {
            System.out.println(Thread.currentThread().getName());
            return n* 10;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName());
            return 30;
        }).thenApplyAsync((n) -> {

            System.out.println(Thread.currentThread().getName());
            return n * 10;
        });

        CompletableFuture<Integer> combine = cf2.thenCombineAsync(cf1, (a , b) -> a * b);
        System.out.println(combine.join());
        System.out.println(Thread.currentThread().getName());
        
    }
}
