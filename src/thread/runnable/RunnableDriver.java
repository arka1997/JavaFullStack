package thread.runnable;

class SendSms extends SendNotification implements Runnable {
    @Override
    public void run(){
        System.out.println("Started sending sms" + Thread.currentThread().getName());
    }
}
class SendNotification {
     public void validateNotification() {
        System.out.println("Validating notification...");
    }

    public void logNotification() {
        System.out.println("Logging notification...");
    }
}

// abstract class SendNotification {
//     public abstract void run();
// }
public class RunnableDriver {
    public static void main(String[] args) {
        // Now i will create a class, that extends runnable interface, and as we no, a class can extend another class, but can implement multiple interfaces.
        // This solves the problem of Child classes. From now-onwards they can use Threads to process some defined tasks under run()
        SendSms s = new SendSms(); // Create Object of the class one time
        // Then create multiple threads to perform the series of tasks
        Thread t1 = new Thread(s);
        t1.start();

        
    }
}
// difference between using runnable and thread class 
// In Thread We can make a class extend just one more class, i.e., Thread. In Runnable, we can implement Runnable, for achieving Thread functionalities, as well as another parent class.