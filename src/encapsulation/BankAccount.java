package encapsulation;

// Encapsulation is like a secured bank, where we keep everything securely, and no one is allowed to access the private variables. They can only read or modify thorugh getters and setters
// Question? But Users can still play with the values with setters. But earlier from User class, they could set any vaues, whatever they want, negative, positive zero. 
// But setter has various security checks, edge cases, so a person cannot just play, there will be multiple checks, the security gates, and after passing every 
// success ful gates, then he can modfy with setter. Even we can verify, if the person making the Setter request is a legitimate Banks Customer or an outsider.
// BankAccount.java

public class BankAccount {

    // Private = outsiders cannot directly access these values.
    private String accountNumber;
    private String accountHolder;
    private static double balance = 0;
    private boolean active;
    private String bank;
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
        this.active = true;
    }

    /*
     * GETTER
     *
     * Outside users cannot directly access balance:
     *
     * account.balance;          // ❌ Not allowed
     *
     * They must come through this controlled pipeline.
     */
    public double getBalance() {
        return balance;
    }

    /*
     * Controlled operation to deposit money.
     *
     * The outside user cannot simply write:
     *
     * account.balance = 1000000;    // ❌
     *
     * Instead, the request comes through this security gate.
     */
    public void deposit(double amount) {

        // Security check 1: Is the account active?
        if (!active) {
            System.out.println("Account is inactive.");
            return;
        }

        // Security check 2: Is the amount valid?
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }

        // Passed all checks → modify internal state
        balance += amount;

        System.out.println("Deposit successful.");
    }

    /*
     * Controlled operation to withdraw money.
     */
    public void withdraw(double amount) {

        // Security check 1
        if (!active) {
            System.out.println("Account is inactive.");
            return;
        }

        // Security check 2
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return;
        }

        // Security check 3
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Passed all checks
        balance -= amount;

        System.out.println("Withdrawal successful.");
    }

    /*
     * Another controlled operation.
     */
    public void closeAccount() {
        active = false;
        System.out.println("Account closed.");
    }

    public boolean isActive() {
        return active;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}


    //              BANK ACCOUNT
    //     ┌──────────────────────────┐
    //     │ private balance           │
    //     │ private accountNumber     │
    //     │ private active            │
    //     └────────────┬─────────────┘
    //                  │
    //           Controlled methods
    //                  │
    //    ┌─────────────┼─────────────┐
    //    ↓             ↓             ↓
    // deposit()    withdraw()    closeAccount()
    //    │             │             │
    // checks         checks         checks
    //    │             │             │
    //    └─────────────┼─────────────┘
    //                  ↓
    //          Internal state changes