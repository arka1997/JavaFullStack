package multithreading_concurrency.callable.sendemail;

import java.util.concurrent.*;

class EmailSenderJob implements Callable<Boolean>{
    EmailSenderTask send;
    EmailSenderJob(EmailSenderTask send) {
        this.send = send;
    }
    @Override 
    public Boolean call(){
        return send.sendEmail(send.email, send.body);
    }
}
public class ThreadDriver {
    public static void main(String[] args) throws InterruptedException, ExecutionException { 
        System.out.println("Main START" + Thread.currentThread().getName());
        // Different Pools ->
        // 1) Fixed Thread Pool -> newFixedThreadPool
        // 2) Dynamic Thread Pool newCahedThreadPool
        // 3) Single Threaded Pool -> newSingleThreadExecutor
        // How we determine which one to use -> Depends on the task load, amount of CPU resource given to it. And if we are not aware,then we can use newThreadCachedPool, where CPu will calculte assign no. of Threads depending on Task Load
        try (ExecutorService exe = Executors.newFixedThreadPool(10)) {
            for(int i = 0; i < 100; i++){
                EmailSenderTask task = new EmailSenderTask("deba@gmail.com"+i, "This is email body"+i);
                EmailSenderJob job = new EmailSenderJob(task);
                Future<Boolean> future = exe.submit(job);
                // This .get is blocking, as the main thread has to wait, until the exisiting Threads are done executing the task
                System.out.println("Email Status is: " + future.get()); // iF i WANT TO see the result, I will call future.get()
            }
        }

        System.out.println("Main END" + Thread.currentThread().getName());
    }
}
