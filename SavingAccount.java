package BankingApplication1;

public class SavingAccount implements Account{
    private String accountName;
    private int accountNumber;
    private double balance;
    private String accountType;

    public SavingAccount (int accountNumber , String accountName , double balance){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public int getNumber (){
        return this.accountNumber;
    }
    public String getName (){
        return this.accountName;
    }
    @Override
    public void deposit(double amount){
        this.balance = this.balance + amount;
    }
    @Override
    public void withdraw(double amount){
        this.balance = this.balance - amount;
    }
    @Override
    public double getBalance(){
        return this.balance;
    }
    @Override
    public String getAccountType(){
        return this.accountType;s
    }

}
