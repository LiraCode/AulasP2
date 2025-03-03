package atv_2025_02_26.models.entities;

public class Account {
    private int numberAccount;
    private final String holderName;
    private double balance;
    private double withdrawLimit;

    public Account(int numberAccount, String holderName, double balance, double withdrawLimit) {
        setNumberAccount(numberAccount);
        this.holderName = holderName;
        setBalance(balance);
        setWithdrawLimit(withdrawLimit);


    }
    public int getNumberAccount() {
        return numberAccount;
    }
    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }
    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + " to " + getHolderName() + ". Account: " + getNumberAccount());
    }
    public void withdraw(double amount) {
        double withdrawLimit = getWithdrawLimit();
        double balance = getBalance();

        try{
            if (amount < withdrawLimit) {
                if (amount < balance) {
                    this.balance -= amount;
                    System.out.println("New balance: " + this.balance);
                } else {
                    throw new NegativeBalance();
                }
            } else {
                throw new WithdrawOutRange();
            }
        } catch(NegativeBalance | WithdrawOutRange e){
            System.out.println(e.getMessage());
        }
    }

}
class NegativeBalance extends Exception {
    public NegativeBalance() {
        super("Withdraw error: Not enough balance");

    }
}
class WithdrawOutRange extends Exception {
    public WithdrawOutRange() {
        super("Withdraw error: The amount exceeds withdraw limit");
    }
}
