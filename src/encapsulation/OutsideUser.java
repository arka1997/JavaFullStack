package encapsulation;

// Now If an outside tries to set negative balance, or try to increase his balance, then he can't, goes, of security checks in setter
// To use get his bank balance, he has to get or set it, through getters or setters, which are like pipelines with series of checks

public class OutsideUser {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("123456789", "Deba");

        BankAccount account2 =
                new BankAccount("987654321", "Puku");
        /*
         * OUTSIDER CANNOT DIRECTLY TOUCH PRIVATE DATA
         */

        // account.balance = 50000;   // ❌
        // account.active = false;    // ❌
        // account.accountNumber = "999999999";  // ❌


        /*
         * Instead, the outsider must go through
         * controlled public methods.
         */
        account.deposit(50000);

        System.out.println(
                "Current Balance: " + account.getBalance()
        );

        account.withdraw(10000);

        System.out.println(
                "Current Balance: " + account.getBalance()
        );

        account2.deposit(20000);
        System.out.println("Current Balance: " + account2.getBalance());

        

        /*
         * Try invalid operations.
         */

        account.deposit(-5000);
        // ❌ Rejected by validation

        account.withdraw(100000);
        // ❌ Rejected because insufficient balance


        /*
         * Close the account.
         */

        account.closeAccount();

        /*
         * Now even a valid deposit is rejected
         * because another security check exists.
         */

        account.deposit(5000);
        // ❌ Account is inactive
    }
}