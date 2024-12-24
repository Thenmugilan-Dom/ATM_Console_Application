import java.util.ArrayList;
import java.util.Scanner;

public class AdminActions
{
    private ArrayList<User> users;
    private ArrayList<String> transactions;
    private Scanner sc = new Scanner(System.in);

    public AdminActions(ArrayList<User> users, ArrayList<String> transactions) {
        this.users = users;
        this.transactions = transactions;
    }

    public void adminLogin(String adminId, String adminPassword)
    {
        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        if (id.equals(adminId) && password.equals(adminPassword))
        {
            System.out.println("Admin logged in successfully.");
            adminMenu();
        }
        else
        {
            System.out.println("Invalid Admin credentials.");
        }
    }

    private void adminMenu()
    {
        while (true)
        {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add User\n2. Delete User\n3. View Users\n4. Add Money to ATM\n5. View Transactions\n6. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice)
            {
                case 1:
                    adminAddUser();
                    break;
                case 2:
                    adminDeleteUser();
                    break;
                case 3:
                    adminViewUsers();
                    break;
                case 4:
                    adminAddMoneyToATM();
                    break;
                case 5:
                    adminViewTransactions();
                    break;
                case 6:
                    System.out.println("Admin logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void adminAddUser()
    {
        System.out.print("Enter new username: ");
        String username = sc.nextLine();
        System.out.print("Enter new password: ");
        String password = sc.nextLine();
        users.add(new User(username, password));
        System.out.println("User added successfully.");
    }

    private void adminDeleteUser()
    {
        System.out.print("Enter username to delete: ");
        String username = sc.nextLine();
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("User deleted successfully.");
    }

    private void adminViewUsers()
    {
        System.out.println("List of users:");
        for (User user : users)
        {
            System.out.println(user.getUsername());
        }
    }

    private void adminAddMoneyToATM()
    {
        System.out.print("Enter amount to add: ");
        double amount = Double.parseDouble(sc.nextLine());
        transactions.add("ATM deposit: " + amount);
        System.out.println("Money added to ATM successfully.");
    }

    private void adminViewTransactions()
    {
        System.out.println("Transaction History:");
        for (String transaction : transactions)
        {
            System.out.println(transaction);
        }
    }
}
