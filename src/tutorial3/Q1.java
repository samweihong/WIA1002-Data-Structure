package tutorial3;

import java.util.Scanner;

public class Q1 {
    /* a.
     * Dispenser:
     * String item (The name of the item)
     * double cost (The cost of the item)
     *
     * CashRegister:
     * double amount (The amount of money in this cash register)
     *
     * CandyMachine:
     * Dispenser candies (Dispenser holding the candies)
     * Dispenser chips (Dispenser holding the chips)
     * Dispenser gum (Dispenser holding the gum)
     * Dispenser cookies (Dispenser holding the cookies)
     * CashRegister cashRegister (Cash register of this machine)
     *
     * b.
     * Dispenser:
     * void getItem() (Gets the name of the item)
     * void getCost() (Gets the cost of the item)
     * void releaseItem() (Releases the item to the customer)
     *
     * CashRegister:
     * void acceptMoney(double amount) (Accepts the money from the customer)
     * void returnChange(double amount) (Returns the change to the customer)
     *
     * CandyMachine:
     * void showProducts() (Shows the customer the different products sold)
     * Dispenser select() (Allows the customer to make the selection)
     * void showCost(Dispenser dispenser) (Shows the customer the cost of the item selected)
     * void startProgram() (Starts the application program)
     */
    public static void main(String[] args) {
        new CandyMachine().startProgram();
    }
}

class Dispenser {
    private String item;
    private double cost;

    public Dispenser(String item, double cost) {
        this.item = item;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public double getCost() {
        return cost;
    }

    public void releaseItem() {
        System.out.println(item + " is released!");
    }
}

class CashRegister {
    private double amount = 100;

    public void acceptMoney(double amount) {
        this.amount += amount;
    }

    public void returnChange(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Cash not enough");
        if (amount > this.amount)
            throw new IllegalArgumentException("Not enough change");
        this.amount -= amount;
        System.out.printf("A change of RM %.2f is returned.\n", amount);
    }
}

class CandyMachine {
    private Dispenser candies = new Dispenser("Candies", 1.00);
    private Dispenser chips = new Dispenser("Chips", 3.50);
    private Dispenser gum = new Dispenser("Gum", 1.20);
    private Dispenser cookies = new Dispenser("Cookies", 5.00);
    private CashRegister cashRegister = new CashRegister();

    public void showProducts() {
        System.out.println("Products: ");
        System.out.println("[1] " + candies.getItem());
        System.out.println("[2] " + chips.getItem());
        System.out.println("[3] " + gum.getItem());
        System.out.println("[4] " + cookies.getItem());
    }

    public Dispenser select() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select a product: ");
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> candies;
            case 2 -> chips;
            case 3 -> gum;
            case 4 -> cookies;
            default -> throw new IllegalStateException("Invalid selection");
        };
    }

    public void showCost(Dispenser dispenser) {
        System.out.printf("Cost of the item selected: RM %.2f\n", dispenser.getCost());
    }

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showProducts();

            Dispenser dispenser = select();
            showCost(dispenser);

            System.out.print("\nInsert money: ");
            double amount = scanner.nextDouble();
            cashRegister.acceptMoney(amount);
            cashRegister.returnChange(amount-dispenser.getCost());

            dispenser.releaseItem();
            System.out.println();
        }
    }
}