package multithreading_concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EmailSender implements Callable<String> {
        
    @Override
    public String call(){
        System.out.println(Thread.currentThread().getName());
        return "I am Calable";
    }
}
public class CallableExecutorDriver {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService e = Executors.newFixedThreadPool(14);
        EmailSender em = new EmailSender();
        for(int i = 0; i < 10; i++){
            Future<String> f = e.submit(em);
            System.out.println(f.get());
        }
        e.shutdown();
    }
}
