package multithreading_concurrency.thread_driver.inter_thread_communicate.order_payment;

public class Payment extends Thread{
    Task task;
    public Payment(Task task) {
        this.task = task;
    }
        
    @Override
    public void run() {
        super.run();
    }
}
