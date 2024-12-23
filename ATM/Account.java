import java.util.ArrayList;

public class Account
{
    private int id;
    private String pin;
    double balance;
    String transaction;
    private ArrayList<String> transactionHistory;

    public Account(int id, String pass, double balance)
    {
        this.id = id;
        this.pin = pass;
        this.balance = balance;
        this.transactionHistory = new ArrayList<String>();
    }

    public int getAccnumber()
    {
        return id;
    }

    public String getPinno()
    {
        return pin;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public ArrayList<String> getTransactionHistory()  // Getter for transaction history
    {
        return transactionHistory;
    }

    // Add a new transaction to the history
    public void addTransaction(String transaction)
    {
        transactionHistory.add(transaction);
    }
}
