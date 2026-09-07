package thread.thread_driver;

class SBIBanking {
    static int staticBalance = 5000;
    public static void withdraw(int amount){
        // This is Class Lock, for class level Synchronization for static method blocks in a multiThreaded environment.
        synchronized(SBIBanking.class){ 
            if(amount > staticBalance) {
                System.out.println();
            }
        }
    }
    int balance = 4000;
    // We cna put synchronization keyword in method also, but if there is some code, that doesnot need to be a part of synchronization and will slow down the application, then we prefer synchronization block
    public void setWithdraw(int amount) {
        System.out.println("Some 1000 lines of codes, that dont need to be under synchronized block, but as the method is synchronized, these lines also perform slow, but could have been executed by multiple threads");
        System.out.println(
                Thread.currentThread().getName()
                        + " | Checking: Is withdrawal amount greater than balance?"
        );
        synchronized(this){ // This is a Object Level Synchronization block in a multiThreaded environment
            if (amount > balance) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " | ❌ Insufficient Balance"
                                + " | Required = ₹" + amount
                                + " | Available = ₹" + balance
                );

            } else {

                System.out.println(
                        Thread.currentThread().getName()
                                + " | ✅ Balance check passed"
                                + " | Available = ₹" + balance
                                + " | Withdrawal = ₹" + amount
                );

                // Here if we use this sleep, what happens is every thread sees balance as 4000, amount>balance == true, so enters else block, then goes to sleep state. Then once they wake up, they already saw before entering else block, that balance was right, so thatswhy they update the balance, and all threads ends up with negative balance.
                try {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " | ⏸ Going to sleep for 1 second after balance check..."
                    );

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                balance -= amount;

                System.out.println(
                        Thread.currentThread().getName()
                                + " | Withdrawal completed"
                                + " | Balance after withdrawal = ₹" + balance
                );
            }
        }
    }
}


class WithdrawTask implements Runnable {

    SBIBanking bank;

    WithdrawTask(SBIBanking bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.setWithdraw(2000);
        // bank.setWithdraw(1000);
    }
}
public class BankingThreadAppWithSynchronized {

    public static void main(String[] args) {

        SBIBanking bank = new SBIBanking(); // This is the shared object

        // Now we create the Task Object
        WithdrawTask sub = new WithdrawTask(bank);

        Thread t1 = new Thread(sub, "Gpay");
        Thread t2 = new Thread(sub, "Phonepay");
        Thread t3 = new Thread(sub, "ATM");
        Thread t4 = new Thread(sub, "NetBanking");

        System.out.println(
                "Initial account balance = ₹4000"
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(
                "Thank you for updating the balance, Do visit again"
        );
    }

}
