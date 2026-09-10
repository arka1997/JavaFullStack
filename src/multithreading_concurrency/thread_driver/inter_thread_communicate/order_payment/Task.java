package multithreading_concurrency.thread_driver.inter_thread_communicate.order_payment;

public class Task {
    Boolean paymentStatus = false;
    public synchronized void placingOrder(String Order){
        System.out.println(Thread.currentThread().getName() + "bEFORE PLACING AN ORDER, CHECK IF paYMENT FOR THIS oRDER DONE");
        while(!paymentStatus){
            wait();
        }
    }

    public synchronized void processPayment(){
        while(paymentStatus){

        }
    } 
}
