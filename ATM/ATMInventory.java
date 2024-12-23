import java.util.Scanner;

public class ATMInventory
{
    private int[] denominations = {2000, 1000, 500, 200, 100};
    private int[] counts = {50, 100, 100, 100, 200};

    public int getDenominationCount(int denomination)
    {
        for (int i = 0; i < denominations.length; i++)
        {
            if (denominations[i] == denomination)
            {
                return counts[i];
            }
        }
        return 0;
    }

    public boolean withdraw(int amount)
    {
        int remaining = amount;

        for (int i = 0; i < denominations.length; i++)
        {
            int availableNotes = getDenominationCount(denominations[i]);
            int notesToDispense = remaining / denominations[i];
            notesToDispense = Math.min(notesToDispense, availableNotes);

            // Deduct the used notes
            counts[i] -= notesToDispense;

            remaining -= notesToDispense * denominations[i];

            if (remaining == 0)
            {
                break;
            }
        }

        return remaining == 0;
    }

    public boolean depositAmount(double amount)
    {
        int intAmount = (int) amount;

        if (intAmount % 100 != 0)
        {
            System.out.println("Amount must be in denominations of 100 or more.");
            return false;
        }

        for (int i = 0; i < denominations.length; i++)
        {
            counts[i] += (intAmount / denominations[i]);
            intAmount %= denominations[i];
        }

        return true;
    }

    public void printInventory()
    {
        System.out.println("ATM Cash Inventory:");
        for (int i = 0; i < denominations.length; i++)
        {
            System.out.println("Denomination: " + denominations[i] + " | Count: " + counts[i]);
        }
    }
}



