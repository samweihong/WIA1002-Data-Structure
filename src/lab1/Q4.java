package lab1;

import java.util.ArrayList;
import java.util.Date;

public class Q4 {
    public static void main(String[] args) {
        Account1 account1 = new Account1("George", 1122, 1000);
        Account1.setAnnualInterestRate(1.5);
        account1.deposit(30);
        account1.deposit(40);
        account1.deposit(50);
        account1.withdraw(5);
        account1.withdraw(4);
        account1.withdraw(2);
        System.out.println("Account Holder Name: " + account1.getName());
        System.out.println("Annual Interest Rate: " + account1.getAnnualInterestRate());
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Transaction History: ");
        for (Transaction t : account1.getTransactions()) {
            System.out.println(t.getDescription());
        }
    }
}

class Account1 extends Account {
    private String name;
    private ArrayList<Transaction> transactions;

    public Account1(String name, int id, double balance) {
        super(id, balance);
        this.name = name;
        transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        String description = String.format("%s withdrew %.2f on %s. Balance: %.2f", name, amount, getDateCreated(), getBalance());
        transactions.add(new Transaction('W', amount, getBalance(), description));
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        String description = String.format("%s deposited %.2f on %s. Balance: %.2f", name, amount, getDateCreated(), getBalance());
        transactions.add(new Transaction('D', amount, getBalance(), description));
    }
}

class Transaction {
    private Date date;
    private char type;

    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description) {
        date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
