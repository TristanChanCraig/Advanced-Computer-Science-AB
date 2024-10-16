package Q1.Pelican_42_7;

public class BankAccount {
    public String name;
    public double balance;

    public BankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }

    public void deposit(double dp) { balance += dp; }
    public void withdraw(double wd) { balance -= wd; }
}
