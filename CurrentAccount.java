package BankingApplication1;

public class CurrentAccount implements Account{
    private String accountName;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double minimum;
    private  final String AccountType = "Current Account";

    public CurrentAccount (int accountNumber , String accountName , double balance , double minimum){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.minimum = minimum;

    }
    public int getAccountNumber (){
        return this.accountNumber;
    }
    public String getAccountNameName (){
        return this.accountName;
    }
    public double getMinimum (){
        return this.minimum;
    }
    public void setMinimum (double minimum){
        this.minimum = minimum;
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
        return this.accountType;
    }

}
