package BankingApplication1;

import java.sql.*;

public class Bank {
    private String name;

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public void listAccount() {
        Connection connection = BankingConnection.connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM account";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                System.out.println(results.getString(1)
                        + results.getString(2)
                        + results.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void openAccount(Account account) {
        Connection connection = BankingConnection.connect();
        String sql = "INSERT INTO account(accNumber,accName,accBalance,accType)" + "VALUES(?,?,?.?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setDouble(3, account.getBalance());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void closeAccount(int number) {
        Connection connection = BankingConnection.connect();
        String sql = "DELECT FROM account WHERE accNumber = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, number);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void depositMoney(Account account, double amount) {
        account.deposit(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance = ? WHERE accNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            System.out.println("Balance : " + account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void withdrawMoney(Account account, double amount) {
        account.withdraw(amount);
        Connection connection = BankingConnection.connect();
        String sql = "UPDATE account SET accBalance = ? WHERE accNumber = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());

            System.out.println("Balance : " + account.getBalance());
            preparedStatement.executeUpdate();
            System.out.println("Balance : " + account.getBalance());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Account getAccount(int accountNumber) {String accountType){
        Connection connection = BankingConnection.connect();
        String sql = "SELECT * FROM account WHERE accNumber = ? AND accType = ?";
        PreparedStatement preparedStatement;
        Account account = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,accountNumber);
            preparedStatement.setString(2,accountType);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            String accName = result.getString(2);
            double balance = result.getDouble(3);
            int minimum = 1000;

            if(accountType.equals("SavingsAccount")) {
                account = new SavingAccount(accountNumber, accName, balance);
            }
            else if(accountType.equals("CurrentAccount")){
                account = new CurrentAccount(accountNumber , accName , balance, minimum);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    public double getBalance(int number) {
        return getBalance(number);
    }

}
}
