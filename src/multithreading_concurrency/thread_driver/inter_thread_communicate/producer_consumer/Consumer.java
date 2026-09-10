package multithreading_concurrency.thread_driver.inter_thread_communicate.producer_consumer;

public class Consumer extends Thread{
    Task task;
    Consumer(Task task){
        this.task = task;
    }

    @Override
    public void run(){
        for(int i = 0; i< 10; i++){
            try {
                System.out.println("Inside Consumer " + Thread.currentThread().getName());
                sleep(1000);
                task.consumeTask();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
