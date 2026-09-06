package thread.runnable;

class Cooking extends Thread{
    @Override
    public void run(){
        System.out.println("Food is being prepared: [" + Thread.currentThread().getName() + "]");
        try {
            sleep(5000);// food is being prepared, Thread(Waiter) is being told to rest
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Food Preparation Done... [" + Thread.currentThread().getName() + "]");
    }
}
public class CookingSleepWait {
    public static void main(String[] args) {
        Thread.currentThread().setName("Waiter");
        System.out.println("Waiter took the order: [" + Thread.currentThread().getName() + "]");
        Cooking t1 = new Cooking();
        t1.setName("cook");
        t1.start(); //Cooking Started
        // What is the use of Join and when to use it ???
        // Join is used to tell the exisitng current thread(here main) to wait, until the new thread t1 completes its execution first, 
        // It is used, when we want a 2nd Thread to complete something, and then the 1st Thread(here waiter) took the order. And handed(created) cooking Thread, and itself moved to WAITING state, until the Cooking thread completes cooking. Once cooking done, the waiter thread again continues & starts serving the cooked food. 
        try {
            t1.join();// Internally uses wait, to wait the other thread until t1 completes
            System.out.println("Waiter started serving food [" + Thread.currentThread().getName() + "]");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }    
}
