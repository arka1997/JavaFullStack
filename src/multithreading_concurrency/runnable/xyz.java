package multithreading_concurrency.runnable;
class BankAccount {
    int balance = 0;
    
    // synchronized is supposed to stop threads from overlapping on the SAME object
    public void deposit(int amount, String jobName) {
        balance += amount;
        System.out.println(jobName + " deposited $" + amount + ". Current Balance: $" + balance);
    }
}

// The Flawed Job
class FlawedDepositJob implements Runnable {
    // BAD DESIGN: Every time a job is created, a BRAND NEW object account is created by every Thread. Ends up having different state with different objects.
    BankAccount account = new BankAccount(); 
    
    int depositAmount;         
    String jobName;            

    // Notice we only pass the unique data now, not the shared account
    FlawedDepositJob(int depositAmount, String jobName) {
        // this.account = account;
        this.depositAmount = depositAmount;
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println(account);
        account.deposit(depositAmount, jobName);
    }
}

public class xyz {
    public static void main(String[] args) {
        // We want to deposit money into one single account. 
        // But because of our FlawedDepositJob design, look what happens:
        BankAccount b = new BankAccount();
        // FlawedDepositJob job1 = new FlawedDepositJob(b, 50, "Job-1");
        // FlawedDepositJob job2 = new FlawedDepositJob(b, 100, "Job-2");
        // FlawedDepositJob job3 = new FlawedDepositJob(b, 50, "Job-1");
        // FlawedDepositJob job4 = new FlawedDepositJob(b, 100, "Job-2");


        FlawedDepositJob job1 = new FlawedDepositJob(50, "Job-1");
        FlawedDepositJob job2 = new FlawedDepositJob(100, "Job-2");
        FlawedDepositJob job3 = new FlawedDepositJob(50, "Job-1");
        FlawedDepositJob job4 = new FlawedDepositJob(100, "Job-2");

        Thread t2 = new Thread(job1);
        Thread t3 = new Thread(job2);
        Thread t4 = new Thread(job3);
        Thread t5 = new Thread(job4);
        
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

/**
 * Job-1 deposited $50. Current Balance: $50
Job-2 deposited $100. Current Balance: $100
Job-2 deposited $100. Current Balance: $100
Job-1 deposited $50. Current Balance: $50


Job-1 deposited $50. Current Balance: $50
Job-2 deposited $100. Current Balance: $150
Job-1 deposited $50. Current Balance: $200
Job-2 deposited $100. Current Balance: $300
 */