package multithreading_concurrency.runnable;

class PrintNumber implements Runnable {

    private boolean bool = true;
    @Override
    public synchronized void run(){
        for(int i = 0; i< 30; i++){
            try {

                if(bool){
                    bool = false;

                    System.out.println(Thread.currentThread().getName() + " Ready to wait" + i);
                    // Thread.sleep(2000);
                    wait(6000);// The 1st thread that comes here, immediate moves to WAITING state and release the lock, the other thread, then starts executing. Once 6sec gets over, then this thread resumes and prints number again
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
public class PrintNumbersSleepWait {
    public static void main(String[] args) {
        PrintNumber t = new PrintNumber();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        // t4.start();
        // t5.start();
    }    
}
