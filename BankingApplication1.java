package BankingApplication1;

import java.util.Random;
import java.util.Scanner;

public class BankingApplication1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option = 0, accountNumber;
        String accountName,accountType;
        double balance , amount;
        Bank bank = new Bank();
        Account account;
        Scanner scan = new Scanner(System.in);
        while (option != 6) {
            System.out.println("Main Menu");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Enter your choice:");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    bank.listAccount();
                    break;
                case 2:
                    System.out.print("Enter Account Name: ");
                    name = scan.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = scan.nextDouble();
                    number = generateAccountNumber();
                    System.out.println("Enter account type : ");
                    accountType = scan.nextLine();
                    if(accountType.equals("SavingsAccount")) {
                        account = new SavingAccount(accountNumber, accountName, balance);
                    }
                    else if(accountType.equals("CurrentAccount")){
                        account = new CurrentAccount(accountNumber , accountName , balance, minimum);
                    }
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    bank.closeAccount(accountNumber);
                    break;
                case 4:
                    System.out.println("Enter Type : ");
                    accountType = scan.nextLine();
                    System.out.println("Enter amount : ");
                    amount = scan.nextDouble();
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber, accountType);
                    bank.depositMoney(account,amount);
                    break;
                case 5 :
                    System.out.println("Enter Type : ");
                    accountType = scan.nextLine();
                    System.out.println("Enter amount : ");
                    amount = scan.nextDouble();
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    account = bank.getAccount(accountNumber, accountType);
                    bank.withdrawMoney(account,amount);
                    break;

            }
            System.out.println();
        }
    }

    public static int generateAccountNumber() {
        Random rand = new Random();
        int number = 100000 + rand.nextInt(900000);
        return number;
    }
}
