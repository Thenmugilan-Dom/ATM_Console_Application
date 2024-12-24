public class ATMInventory
{
    private int[] den = {2000, 1000, 500, 200, 100};
    private int[] count = {50, 100, 100, 100, 200};

    public boolean depositAmount(double amount)
    {
        //ref from google
        for (int i = 0; i< den.length; i++)
        {
            double counts = amount / den[i];

            count[i] += counts;
            amount %= den[i];

            if (amount == 0)
            {
                break;
            }
        }

        return true;

    }

}



