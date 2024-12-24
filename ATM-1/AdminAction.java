import java.util.Scanner;

public class AdminAction extends Account
{
    private ATMInventory atmInventory;

    public AdminAction(int id, String pass,double balanced, ATMInventory atmInventory)
    {
        super(id, pass, balanced);
        this.atmInventory = atmInventory;
    }

    public void checkBalance()
    {
        System.out.println("Your balance is: " + getBalance());
    }

    public void addNewUser(Scanner scanner)
    {
        System.out.println("Enter new user account number: ");
        int accno = scanner.nextInt();

        System.out.println("Enter new user PIN: ");
        String pin = scanner.next();

        System.out.println("Enter the Initial amount");
        double balance = scanner.nextDouble();

        UserAction newUser = new UserAction(accno, pin, balance);
        ATM.userAccounts.add(newUser);
        System.out.println("New user added successfully.");

        addTransaction("Added new user with ID: " + accno + " and balance: " + balance);
    }

    public void deleteUser(Scanner scanner)
    {
        System.out.println("Enter the account number of the user to delete: ");
        int accno = scanner.nextInt();

        Account userToDelete = null;
        for (Account account : ATM.userAccounts)
        {
            if (account.getAccnumber() == accno)
            {
                userToDelete = account;
                break;
            }
        }

        if (userToDelete != null)
        {
            ATM.userAccounts.remove(userToDelete);
            System.out.println("User deleted successfully.");
        }

        else
        {
            System.out.println("User not found.");
        }

        addTransaction("Deleted user ID is: " + accno);
    }

    public void viewAllAccounts()
    {
        if (ATM.userAccounts.isEmpty())
        {
            System.out.println("There are no accounts.");
        }

        else
        {
            System.out.println("All user accounts:");
            for (Account account : ATM.userAccounts)
            {
                System.out.println("Account No:\n " + account.getAccnumber());
            }
        }
    }

    public void ADeposit(Scanner scanner)
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

        if (atmInventory == null)
        {
            System.out.println("ATM inventory is not initialized.");
            return;
        }


        if (atmInventory.depositAmount(amount))
        {
            setBalance(getBalance() + amount);
            System.out.println("\nDeposit successful. ATM balance updated.");
            addTransaction("Deposited: " + amount + ". balance: " + getBalance());
        }
        else
        {
            System.out.println("Failed to deposit. ATM cannot hold this amount.");
        }
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






