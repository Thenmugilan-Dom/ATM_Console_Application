import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        ATMInventory atmInventory = new ATMInventory();
        AdminAction adminAction = new AdminAction(12345, "12345", 1000,atmInventory);


        ATM atm = new ATM();
        atm.start(scanner, adminAction, atmInventory);
    }
}



