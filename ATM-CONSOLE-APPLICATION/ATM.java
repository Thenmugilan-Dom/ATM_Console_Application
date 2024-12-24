import java.util.ArrayList;
import java.util.Scanner;

public class ATM
{
    private String adminId = "admin";
    private String adminPassword = "1234";
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> transactions = new ArrayList<>();

    private int[] denominations = {2000, 500, 200, 100};
    private int[] denominationCounts = {0, 0, 0, 0};
    private AdminActions adminActions;
    private UserActions userActions;

    public ATM()
    {
        adminActions = new AdminActions(users, transactions, denominations, denominationCounts);
        userActions = new UserActions(users, transactions, denominations, denominationCounts);
    }

    public void start()
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("\nATM System Menu:");
            System.out.println("1. Admin Login\n2. User Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice)
            {
                case 1:
                    adminActions.adminLogin(adminId, adminPassword);
                    break;
                case 2:
                    userActions.userLogin();
                    break;
                case 3:
                    System.out.println("Exiting the ATM system...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
