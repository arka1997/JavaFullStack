package multithreading_concurrency.thread_driver;

// Create a shared SBIBanking Object, where multiple threads from Gpay, Phone Pay, NetBanking, can come to modify the balance, if a person Father
//  tries to withdraw from same account, then son, then mother then GF, all trying to withdraw from same SBI account, then how can we prevent 
// RACE conditions, where data descrepency might occur, and how to synchronisedly update the balance, irrespective of multiple threads. Adding, updating, same shared balance by threads
// The balance was competely wrong, and going to negative, without knowing of the Threads.
class SBIBanking {

    private int balance = 4000;

    public void getDeposit() {
        System.out.println(
                Thread.currentThread().getName()
                        + " | Checking current balance = ₹" + balance
        );
    }

    public void setDeposit(int amount) {

        System.out.println(
                Thread.currentThread().getName()
                        + " | Depositing ₹" + amount
                        + " | Balance before deposit = ₹" + balance
        );

        balance += amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " | Deposit completed"
                        + " | Balance after deposit = ₹" + balance
        );
    }

    public void setWithdraw(int amount) {

        System.out.println(
                Thread.currentThread().getName()
                        + " | Checking: Is withdrawal amount greater than balance?"
        );

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


class DepositTask implements Runnable {

    SBIBanking bank;

    DepositTask(SBIBanking bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.setDeposit(500);
    }
}


class WithdrawTask implements Runnable {

    SBIBanking bank;

    WithdrawTask(SBIBanking bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.setWithdraw(1000);
        bank.setWithdraw(1000);
    }
}


public class BankingThreadAppWithouSynchronized {

    public static void main(String[] args) {

        SBIBanking bank = new SBIBanking(); // This is the shared object

        // Now we create the Task Object
        DepositTask add = new DepositTask(bank);
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