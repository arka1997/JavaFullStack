package multithreading_concurrency.runnable;

public class PrintNumbers implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Number is" + i);
            if(i == 5){
                System.out.println(" Sending " + Thread.currentThread().getName() + "to sleeping/timed waiting state");

                try{
                    Thread.currentThread().sleep(5000);
                    Thread.currentThread().wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sleep time over, Starting execution again.....");
            }
        }
    }
}

class Driver {
    public static void main(String[] args) {
        PrintNumbers p = new PrintNumbers();
        Thread t1 = new Thread(p);
        t1.start();
        t1.start();//This throws an exception. Once a thread starts, executes run(), and then Terminates, then its dead. We can't start it again.
    }
}
