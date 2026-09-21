package multithreading_concurrency.runnable;

class BankAccount {
    int balance = 0;
    
    // synchronized is supposed to stop threads from overlapping on the SAME object
    public synchronized void deposit(int amount, String jobName) {
        balance += amount;
        System.out.println(jobName + " deposited $" + amount + ". Current Balance: $" + balance);
    }
}

// ---------------------------------------------------------
// SCENARIO 1: WITHOUT CONSTRUCTOR INJECTION (TIGHT COUPLING)
// ---------------------------------------------------------
class FlawedDepositJob implements Runnable {
    // BAD DESIGN: Every time a job is created, a BRAND NEW object account is created by every Thread. 
    // Ends up having different state with different objects.
    BankAccount account = new BankAccount(); 
    
    int depositAmount;         
    String jobName;            

    // Notice we only pass the unique data now, not the shared account
    FlawedDepositJob(int depositAmount, String jobName) {
        this.depositAmount = depositAmount;
        this.jobName = jobName;
    }

    @Override
    public void run() {
        account.deposit(depositAmount, jobName);
    }
}

// ---------------------------------------------------------
// SCENARIO 2: WITH CONSTRUCTOR INJECTION (DEPENDENCY INJECTION)
// ---------------------------------------------------------
class CorrectDepositJob implements Runnable {
    // GOOD DESIGN: We don't create the account here. 
    // We accept the shared account from the outside.
    BankAccount account; 
    
    int depositAmount;         
    String jobName;            

    // Notice we pass BOTH the shared account and the unique data
    CorrectDepositJob(BankAccount account, int depositAmount, String jobName) {
        this.account = account;
        this.depositAmount = depositAmount;
        this.jobName = jobName;
    }

    @Override
    public void run() {
        account.deposit(depositAmount, jobName);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("--- SCENARIO 1: FLAWED DESIGN (NO CONSTRUCTOR INJECTION) ---");
        // We want to deposit money into one single account. 
        // But because of our FlawedDepositJob design, look what happens:
        FlawedDepositJob job1 = new FlawedDepositJob(50, "Flawed-Job-1");
        FlawedDepositJob job2 = new FlawedDepositJob(100, "Flawed-Job-2");
        FlawedDepositJob job3 = new FlawedDepositJob(50, "Flawed-Job-3");
        FlawedDepositJob job4 = new FlawedDepositJob(100, "Flawed-Job-4");

        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job2);
        Thread t3 = new Thread(job3);
        Thread t4 = new Thread(job4);
        
        t1.start(); t2.start(); t3.start(); t4.start();
        
        // Wait for flawed threads to finish before starting the next test
        t1.join(); t2.join(); t3.join(); t4.join();
        
        
        System.out.println("\n--- SCENARIO 2: CORRECT DESIGN (CONSTRUCTOR INJECTION) ---");
        // We create ONE shared BankAccount object here in main.
        BankAccount sharedAccount = new BankAccount();
        
        // We inject the EXACT SAME sharedAccount into every job!
        CorrectDepositJob cJob1 = new CorrectDepositJob(sharedAccount, 50, "Correct-Job-1");
        CorrectDepositJob cJob2 = new CorrectDepositJob(sharedAccount, 100, "Correct-Job-2");
        CorrectDepositJob cJob3 = new CorrectDepositJob(sharedAccount, 50, "Correct-Job-3");
        CorrectDepositJob cJob4 = new CorrectDepositJob(sharedAccount, 100, "Correct-Job-4");
        
        Thread ct1 = new Thread(cJob1);
        Thread ct2 = new Thread(cJob2);
        Thread ct3 = new Thread(cJob3);
        Thread ct4 = new Thread(cJob4);
        
        ct1.start(); ct2.start(); ct3.start(); ct4.start();
    }
}

/** EXPECTED OUTPUT:
--- SCENARIO 1: FLAWED DESIGN (NO CONSTRUCTOR INJECTION) ---
Flawed-Job-1 deposited $50. Current Balance: $50
Flawed-Job-4 deposited $100. Current Balance: $100
Flawed-Job-3 deposited $50. Current Balance: $50
Flawed-Job-2 deposited $100. Current Balance: $100

--- SCENARIO 2: CORRECT DESIGN (CONSTRUCTOR INJECTION) ---
Correct-Job-1 deposited $50. Current Balance: $50
Correct-Job-4 deposited $100. Current Balance: $150
Correct-Job-3 deposited $50. Current Balance: $200
Correct-Job-2 deposited $100. Current Balance: $300
*/