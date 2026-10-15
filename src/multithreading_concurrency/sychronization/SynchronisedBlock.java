package multithreading_concurrency.sychronization;

class BankAccount {
    private int balance = 1000;
    public void deposit(BankAccount receiver, int amount){
        System.out.println("Some 200+ lines of code " + Thread.currentThread().getName() + " Sending email notification... requested the fund transfer");
        synchronized(this){
            if(balance > amount) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - amount;
                receiver.balance += amount;
                System.out.println("File Tranfarred amount " + amount + " remaining balance " + balance + Thread.currentThread().getName());
            } else{
                System.out.println("Insufficient balance, Requested " + amount + " balance left " + balance + Thread.currentThread().getName());
            }
        }
        System.out.println("Some 200+ lines of code " + Thread.currentThread().getName() + " Sending email notification... Fund transfer done");
        
    }
    public int getBalance(){
        return balance;
    }
}
class BankAccountJob implements Runnable{
    BankAccount send;
    BankAccount receive;

    BankAccountJob(BankAccount send, BankAccount receive){
        this.send = send;
        this.receive = receive;
    }

    @Override 
    public void run(){
        send.deposit(receive, 100);
        System.out.println("Received account balance " + receive.getBalance() + Thread.currentThread().getName());
    }
}
public class SynchronisedBlock {
    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount();
        BankAccount obj2 = new BankAccount();
        BankAccountJob job = new BankAccountJob(obj1, obj2);
        Thread t1 = new Thread(job);
        Thread t2 = new Thread(job);
        Thread t3 = new Thread(job);
        Thread t4 = new Thread(job);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}