package tutorial1;

public class Q5 {
    // Playground
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        System.out.println(account.deposit(123));
        System.out.println(account.withdraw(300));
        System.out.println(account.withdraw(20));
        System.out.println(account.withdraw(103));
    }
}

interface Account {
    int deposit(int amount);
    boolean withdraw(int amount);
}

class BankAccount implements Account {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    @Override
    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}