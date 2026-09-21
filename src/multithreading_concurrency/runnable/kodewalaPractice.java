package multithreading_concurrency.runnable;


class Task extends PrintNumber implements Runnable{


    // Use of Thread sleep -> Supoose there is a. email sending task, which takes 4 seconds. So we make current thread to wait for another task(email) to complete, and then resume the current thread
    @Override
    public void run(){
        for(int i = 0; i< 10; i++){
            if(i==5){
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread is sleeping" + Thread.currentThread().getName());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Run method is getting executed" + i);
        }
    }
}

// Synchronizations means one thread at a time on a same shared Object
class Task2 {
    public synchronized void printNumbers(){
        for(int i = 0; i < 10; i++ ){
            System.out.println("Printing number " + i + " Current Thread executing " + Thread.currentThread().getName() );
        }
    }
}


class PrinterThread implements Runnable {
    Task2 task2; // But we don't keep it like this, because its tightly coupled defined statically. Now if there are multiple tasks, then we just simply pass that through constructor
    PrinterThread(Task2 task2){
        this.task2 = task2;
    }
    @Override 
    public void run(){
        task2.printNumbers();
    }
}

class PrinterThread2 implements Runnable {
    Task2 task2 = new Task2(); // If we hard code it like this, then any threads, that will enter this block, will end up creating a different task object

    @Override 
    public void run(){
        System.out.println(task2 + Thread.currentThread().getName());
        task2.printNumbers();
    }
}


public class kodewalaPractice {
    public static void main(String[] args) {
        // Task task = new Task();
        // Thread t1 = new Thread(task);
        // t1.start();
        Task2 task2 = new Task2();
        // PrinterThread print2 = new PrinterThread(task2);
        // System.out.println("Driver main() thread END");
        PrinterThread2 print = new PrinterThread2();
        Thread t2 = new Thread(print);
        Thread t3 = new Thread(print);
        Thread t4 = new Thread(print);
        Thread t5 = new Thread(print);
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
