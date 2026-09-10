package multithreading_concurrency;

public class SingleVsMultiThreadSpeed {

    static long doWork(int start, int end) {

        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i * i;
        }

        return sum;
    }

    public static void main(String[] args) throws InterruptedException {

        int max = 200_000_000;

        // ---------------- SINGLE THREAD ----------------

        long startTime = System.currentTimeMillis();

        doWork(1, max);
        doWork(1, max);
        doWork(1, max);
        doWork(1, max);

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Single Thread Time: "
                + (endTime - startTime) + " ms"
        );


        // ---------------- MULTIPLE THREADS ----------------

        Thread t1 = new Thread(() -> doWork(1, max));
        Thread t2 = new Thread(() -> doWork(1, max));
        Thread t3 = new Thread(() -> doWork(1, max));
        Thread t4 = new Thread(() -> doWork(1, max));

        startTime = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        endTime = System.currentTimeMillis();

        System.out.println(
                "Multi Thread Time: "
                + (endTime - startTime) + " ms"
        );
    }
}