import java.util.Scanner;
import java.util.ArrayList;

public class ATM
{
    public static ArrayList<Account> userAccounts = new ArrayList<>();

    public void start(Scanner scanner, AdminAction adminAction, ATMInventory atmInventory)
    {
        while (true)
        {
            int choice;
            System.out.println("Select:");
            System.out.println("1. Admin \n2. Customer \n3. Exit");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    Adminop(scanner, adminAction, atmInventory);
                    break;
                case 2:
                    Userop(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void Userop(Scanner scanner)
    {
        System.out.println("Enter your Account number:");
        int uaccno = scanner.nextInt();

        System.out.println("Enter your PIN:");
        String upin = scanner.next();

        Account userAccount = null;

        // Search for the user in the ArrayList
        for (Account account : userAccounts)
        {
            if (account.getAccnumber() == uaccno && account.getPinno().equals(upin))
            {
                userAccount = account;
                break;
            }
        }

        if (userAccount != null)
        {
            System.out.println("Login successful.");
            UserAction userAction = (UserAction) userAccount;
            while (true)
            {
                System.out.println("Enter your operation:");
                System.out.println("1. Check Balance \n2. Withdraw cash \n3. Deposit cash \n4. Change Pin \n5. View Transaction \n6. Exit");
                int ch = scanner.nextInt();
                switch (ch)
                {
                    case 1:
                        userAction.checkBalance();
                        break;
                    case 2:
                        userAction.withdraw(scanner);
                        break;
                    case 3:
                        userAction.deposit(scanner);
                        break;
                    case 4:
                        userAction.changePin(scanner);
                        break;
                    case 5:
                        userAction.printTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Exiting user menu...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        else
        {
            System.out.println("Invalid account number or PIN. Returning to main menu.");
        }
    }

    public static void Adminop(Scanner scanner, AdminAction adminAction, ATMInventory atmInventory)
    {


        System.out.println("Enter the account number:");
        int accno = scanner.nextInt();

        System.out.println("Enter the PIN:");
        String pin = scanner.next();

        for (int i = 0; i < 3; i++)
        {
            if (accno == adminAction.getAccnumber() && pin.equals(adminAction.getPinno()))
            {
                System.out.println("Login successful.");
                break;
            }
            else if (i < 2)
            {
                System.out.println("Wrong PIN or account number. Try again:");
                pin = scanner.next();
            }
            else
            {
                System.out.println("Too many failed attempts. Returning to main menu.");
                return;
            }
        }
        while (true)
        {
            System.out.println("Enter your operation:");
            System.out.println("1. Add new user \n2. Delete user \n3. View all accounts \n4. Deposit \n5.Check Balance  \n6.View Transaction \n7. Exit");
            int ch = scanner.nextInt();
            switch (ch)
            {
                case 1:
                    adminAction.addNewUser(scanner);
                    break;
                case 2:
                    adminAction.deleteUser(scanner);
                    break;
                case 3:
                    adminAction.viewAllAccounts();
                    break;
                case 4:
                    adminAction.ADeposit(scanner);
                    break;
                case 5:
                    adminAction.checkBalance();
                    break;
                case 6:
                    adminAction.printTransactionHistory();
                    break;
                case 7:
                    System.out.println("Exiting admin menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}


