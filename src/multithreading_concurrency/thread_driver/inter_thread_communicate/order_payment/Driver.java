package multithreading_concurrency.thread_driver.inter_thread_communicate.order_payment;

public class Driver {
    public static void main(String[] args) {
        Task task = new Task();

        System.out.println(Thread.currentThread().getName());
        System.out.println("Order started Processing");
        Order t1 = new Order(task);
        Payment t2 = new Payment(task);

        t1.start();
        t2.start();
        // t3.start();
        // t4.start();
    }
}
