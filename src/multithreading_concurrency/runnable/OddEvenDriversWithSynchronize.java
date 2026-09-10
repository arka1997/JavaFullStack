package multithreading_concurrency.runnable;
/** 
 * Start Main()
 * Create Shared Object for multiple Threads (Odd Task & Even Task) -> OddEvenPrinterSynchronised printer = new OddEvenPrinterSynchronised();
 * Create 2 Threads: i) Thread t1 = new Thread(new OddTask) ii) Thread t2 = new Thread(new EvenTask)
 * Start both Thread -> i)t1.start() ii) t2.start()
 * */ 
class OddEvenPrinterSynchronised {
    private int start = 1;
    private final int max = 100; // Used final so that no Threads can chnage its value, as its a multi threaded environment
    // Here both shares the same state of data. So when on thread is processing, lets say even, the other thread shouldn't go, inside odd, and increment the start, then data descrepencies will occur.
    public synchronized void printOddNumbers() throws InterruptedException {
        while(start < max){
            if(start % 2 == 0){
                wait();
            }
            if(start % 2 != 0){
                System.out.println("Printing Odd Numbers in synchronised environment " + start + Thread.currentThread().getName());
            }
            start++;
            notifyAll();
        }
    }
    // Now synchronized, we have kept so that, when an even thread is trying to modify, the odd
    public synchronized void printEvenNumbers() throws InterruptedException {
        while(start < max){
            if(start % 2 != 0){
                wait();
            }
            if(start % 2 == 0){
                System.out.println("Printing Even Numbers in synchronised environment " + start + Thread.currentThread().getName());
            }
            start++;
            notifyAll();
        }
    }
}
class OddTask implements Runnable{

    OddEvenPrinterSynchronised printer;
    public OddTask (OddEvenPrinterSynchronised printer){
        this.printer = printer;
    }
    @Override 
    public void run(){
        try {
            printer.printOddNumbers();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class EvenTask implements Runnable{

    OddEvenPrinterSynchronised printer;
    public EvenTask (OddEvenPrinterSynchronised printer){
        this.printer = printer;
    }
    @Override 
    public void run(){
        try {
            printer.printEvenNumbers();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class OddEvenDriversWithSynchronize {
    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        System.out.println("Main Thread in synchronised environment " + Thread.currentThread().getName());
        // Now here only one object is created, and 2 threads operating on them
        OddEvenPrinterSynchronised printer = new OddEvenPrinterSynchronised(); // Got one Object lock
        //Here only 1 object is created and shared to the threads, so that multiple Threads can work on the same Object
        EvenTask evenTask = new EvenTask(printer);
        OddTask oddTask = new OddTask(printer);

        Thread t1 = new Thread(evenTask); 
        Thread t2 = new Thread(oddTask);
        // t1.start();
        // t2.start();

        /** Here we cannot create/use 2 different objects, then concept of Synchronization is not valid. One thread enters odd block, but value of start = 2(even), then our if block will call wait(), go out of synchronized block and release Object's lock, and giving opportunity for the 2nd thread, to acquire the same shared Objects Lock & start the even block. Now if objects are 2 different, then there state is different. now if one Thread is moved to wait() state, the other thread cannot notify it to wake after completing. The objects need to be same and shared state */



    }
}
