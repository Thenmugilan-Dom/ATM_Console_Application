import java.util.Scanner;
import java.util.ArrayList;

public class UserAction extends Account
{
    private ATMInventory atmInventory;

    public UserAction(int id, String pass, double balance)
    {
        super(id, pass, balance);
    }

    public void checkBalance()
    {
        System.out.println("Your balance is: " + getBalance());
    }

    public void withdraw(Scanner scanner)
    {
        System.out.println("Enter your withdraw amount: ");
        double amount = scanner.nextDouble();

        double newbalance = getBalance() - amount;
        if (amount<= getBalance())
        {
            System.out.println("\n " + newbalance + getBalance());
            addTransaction("Withdrew: " + amount + " New balance: " + newbalance);
        }
        else
        {
            System.out.println("Insufficient amount");
        }
    }

    public void deposit(Scanner scanner)
    {
        System.out.println("Enter amount to deposit: ");
        System.out.println("Enter the how many amount...");
        System.out.println("2000 \n 1000 \n 500 \n 200 \n 100");
        System.out.println("How many 2000 : ");
        double a1 = scanner.nextDouble();

        System.out.println("How many 1000 : ");
        double a2 = scanner.nextDouble();

        System.out.println("How many 500 : ");
        double a3 = scanner.nextDouble();

        System.out.println("How many 200 : ");
        double a4 = scanner.nextDouble();

        System.out.println("How many 100 : ");
        double a5 = scanner.nextDouble();

        double amount = (a1 * 2000) + (a2 * 1000) + (a3 * 500) + (a4 * 200) + (a5 * 100);
        System.out.println("Entered amount is: " + amount);

        if (atmInventory.depositAmount(amount))
        {
            System.out.println("\nDeposit successful. ATM balance updated.");
            addTransaction("Deposited: " + amount + ". New balance: " + getBalance());
        }

        else
        {
            System.out.println("Failed to deposit. ATM cannot hold this amount.");
        }
    }

    public void changePin(Scanner scanner)
    {
        System.out.println("Enter new PIN: ");
        String newPin = scanner.next();

        System.out.println("PIN changed successfully.");
    }

    public void printTransactionHistory()
    {
        System.out.println("Transaction History:");
        for (String transaction : getTransactionHistory())
        {
            System.out.println(transaction);
        }
    }
}
