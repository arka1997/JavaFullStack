package multithreading_concurrency.runnable;

/**
 * Start Main()
 * Create Shared Object for multiple Threads (Odd Task Printer & Even Task Printer) -> OddEvenPrinter printer = new OddEvenPrinter();
 * Create 2 Threads: i) Thread t1 = new Thread(new OddTask) ii) Thread t2 = new Thread(new EvenTask)
 * Start both Thread -> i)t1.start() ii) t2.start()
 */
class OddEvenPrinter {

    private int startOdd = 1;

    private int startEven = 1;
    private final int max = 10000; // Used final so that no Threads can chnage its value, as its a multi threaded environment

    // Here both shares the same state of data. So when on thread is processing, lets say even, the other thread shouldn't go, inside odd, and increment the start, then data descrepencies will occur.
    public void printOddNumbers() throws InterruptedException {

        while (startOdd < max) {

            if (startOdd % 2 != 0) {
                System.out.println(
                        "Printing Odd Numbers in non-synchronised environment " + startOdd
                        + " " + Thread.currentThread().getName()
                );
            }

            startOdd++;
        }
    }

    // Now synchronized, we have kept so that, when an even thread is trying to modify, the odd
    public void printEvenNumbers() throws InterruptedException {

        while (startEven < max) {

            if (startEven % 2 == 0) {
                System.out.println(
                        "Printing Even Numbers  in non-synchronised environment " + startEven
                        + " " + Thread.currentThread().getName()
                );
            }

            startEven++;
        }
    }
}


class OddTask implements Runnable {

    OddEvenPrinter printer;

    public OddTask(OddEvenPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            printer.printOddNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class EvenTask implements Runnable {

    OddEvenPrinter printer;

    public EvenTask(OddEvenPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            printer.printEvenNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class OddEvenDriversWithoutSynchronize {

    public static void main(String[] args) {

        Thread.currentThread().setName("Main");

        System.out.println(
                "Main Thread  in non-synchronised environment " + Thread.currentThread().getName()
        );

        OddEvenPrinter printer = new OddEvenPrinter();

        EvenTask evenTask = new EvenTask(printer);
        OddTask oddTask = new OddTask(printer);

        Thread t1 = new Thread(evenTask);
        Thread t2 = new Thread(oddTask);

        // t1.start();
        // t2.start();



        /** Also we can create 2 different objects- 2 different Locks, and create 2 different threads for 2 different object, and execute them parallely. Where both has different state, and different "start" and max data, nothing is shared */
        OddEvenPrinter printerObj1 = new OddEvenPrinter(); // Got one Object lock
        OddEvenPrinter printerObj2 = new OddEvenPrinter();// Got one Object lock
        EvenTask evenTask2 = new EvenTask(printerObj1);
        OddTask oddTask2 = new OddTask(printerObj2);
        Thread t3 = new Thread(evenTask2);
        Thread t4 = new Thread(oddTask2);

        t3.start();
        t4.start();
    }
}