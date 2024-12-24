import java.util.ArrayList;
import java.util.Scanner;

public class UserActions
{
    private ArrayList<User> users;
    private ArrayList<String> transactions;
    private int[] denominations;
    private int[] denominationCounts;
    private Scanner sc = new Scanner(System.in);

    public UserActions(ArrayList<User> users, ArrayList<String> transactions, int[] denominations, int[] denominationCounts)
    {
        this.users = users;
        this.transactions = transactions;
        this.denominations = denominations;
        this.denominationCounts = denominationCounts;
    }

    public void userLogin()
    {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (User user : users)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                System.out.println("User logged in successfully.");
                userMenu(user);
                return;
            }
        }
        System.out.println("Invalid User credentials.");
    }

    private void userMenu(User user)
    {
        while (true)
        {
            System.out.println("\nUser Menu:");
            System.out.println("1. Withdraw Money\n2. Deposit Money\n3. View Balance\n4. View Transactions\n5. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice)
            {
                case 1:
                    userWithdraw(user);
                    break;
                case 2:
                    userDeposit(user);
                    break;
                case 3:
                    System.out.println("Your balance: " + user.getBalance());
                    break;
                case 4:
                    userViewTransactions();
                    break;
                case 5:
                    System.out.println("User logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void userWithdraw(User user)
    {
        System.out.print("Enter amount to withdraw: ");
        int amount = Integer.parseInt(sc.nextLine());

        if (user.getBalance() >= amount && isAmountDispensable(amount))
        {
            dispenseCash(amount);
            user.setBalance(user.getBalance() - amount);
            transactions.add(user.getUsername() + " withdrew: " + amount);
            System.out.println("Withdrawal successful.");
        }

        else
        {
            System.out.println("Withdrawal failed. Check balance or ATM cash availability.");
        }
    }

    private void userDeposit(User user)
    {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine());
        user.setBalance(user.getBalance() + amount);
        transactions.add(user.getUsername() + " deposited: " + amount);
        System.out.println("Deposit successful.");
    }

    private void userViewTransactions()
    {
        System.out.println("Transaction History:");
        for (String transaction : transactions)
        {
            System.out.println(transaction);
        }
    }

    private boolean isAmountDispensable(int amount)
    {
        int[] tempCounts = denominationCounts.clone();
        for (int i = 0; i < denominations.length; i++) {
            while (amount >= denominations[i] && tempCounts[i] > 0)
            {
                amount -= denominations[i];
                tempCounts[i]--;
            }
        }
        return amount == 0;
    }

    private void dispenseCash(int amount)
    {
        for (int i = 0; i < denominations.length; i++)
        {
            while (amount >= denominations[i] && denominationCounts[i] > 0)
            {
                amount -= denominations[i];
                denominationCounts[i]--;
            }
        }
    }
}
