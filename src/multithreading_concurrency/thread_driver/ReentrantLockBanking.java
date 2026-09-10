package multithreading_concurrency.thread_driver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class SBIBankings {
    private int balance = 4000;
    private final ReentrantLock lock = new ReentrantLock();
    String name = "";
    Boolean acquired = false; 
    public void withdraw(int amount){
        try {
            acquired = lock.tryLock(2, TimeUnit.MILLISECONDS);
            if(acquired){// For 1st thread, it acquires the lock, and not tries
                name = Thread.currentThread().getName();
                System.out.println("Lock Acquired By Thread " + Thread.currentThread().getName());
                if(amount > balance){
                    System.out.println("Insufficient Balanace " + " " + amount + " " + Thread.currentThread().getName());
                } else {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    balance -= amount;
                    System.out.println("Current balance " + balance + " after withdrawing " + amount + " by " + Thread.currentThread().getName());
                }
            } else{
                System.out.println("Lock was not released by one thread " + name + ". Doing some other tasks concurrently with other threads: => " + Thread.currentThread().getName());
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            // This finally block gets executed for every Threads, even when the Thread didn't acquired a lock and tryLock() return TRUE for FIRST Thread, returns FALSE for other threads, until the First Thread releases the lock, and some new threads get to acquire the lock.
            if(acquired){
                lock.unlock(); // We are keeping a check because, earlier, without this check, and storing the bool result in acquired value, we were getting an "IllegalMonitorStateException", as pHONEpAY HOLD THE LOCK, now the other threads, did the other tasks, out of the lock concurrently, but then it goes to finally block, and tries to release the lock by .unlock(). java says, you havent acquired the lock, trying to release what?? So only if acquired is true, by that thread, then only try to release
                System.out.println("Lock Released for Thread " + Thread.currentThread().getName());
            }else{
                System.out.println("Lock was not acquired by this thread => " + Thread.currentThread().getName() + " because " + name + " was already acquiring the Lock. No need to release anything for this");
            }
        }
    }
}

public class ReentrantLockBanking {
    public static void main(String[] args) {
        SBIBankings t = new SBIBankings();
        
        // Creating anonymous class
        Thread t1 = new Thread("PhonePay"){
            @Override
            public void run(){
                t.withdraw(2000);
            }
        };
        Thread t2 = new Thread("Gpay"){
            @Override
            public void run(){
                t.withdraw(2000);
            }
        };

        // Creating lamda expression
        Thread t3 = new Thread(() -> {
            t.withdraw(2000);
        },"NetBank");

        t1.start();
        t2.start();
        t3.start();

        // Another Anonymous way of creating thread
        Runnable task = new Runnable() {
            @Override 
            public void run(){
                t.withdraw(1000);
            }
        };

        Thread t4 = new Thread(task,"ATM");
        t4.start();
    }
}
