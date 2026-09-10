package multithreading_concurrency.thread_driver.inter_thread_communicate.producer_consumer;

public class Driver {
    public static void main(String[] args) {
        Task task = new Task();

        System.out.println(Thread.currentThread().getName());
        Producer t1 = new Producer(task);
        Consumer t2 = new Consumer(task);
        Consumer t3 = new Consumer(task);
        Consumer t4 = new Consumer(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
