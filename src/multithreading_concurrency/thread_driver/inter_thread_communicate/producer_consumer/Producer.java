package multithreading_concurrency.thread_driver.inter_thread_communicate.producer_consumer;

public class Producer extends Thread {
    Task task;
    Producer(Task task){
        this.task = task;
    }
    // ?? tRY TO do the same without loop, just using thread with wait and notify ??
    @Override
    public void run(){
        for(int i = 0; i< 10; i++){
            try {
                sleep(1000);
                System.out.println("Inside Producer " + Thread.currentThread().getName());
                sleep(1000);
                task.produceTask(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
