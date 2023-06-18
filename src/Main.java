import authUser.UserAuth;
import payload.BankDetails;
import payload.TransactionMenu;
import service.Transaction;
import serviceImpl.TransactionImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankDetails bankDetails = new BankDetails();
        TransactionMenu transactionMenu = new TransactionMenu();
        Transaction transaction = new TransactionImpl();

        boolean check;

        bankDetails.createBankLogin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\tUsername: ");
        String currentUser = scanner.nextLine();
        System.out.print("\t\tPin: ");
        Integer currentPin = scanner.nextInt();
        Scanner option = new Scanner(System.in);
        System.out.println();

        if(UserAuth.USERNAME.equals(currentUser) && UserAuth.PIN.equals(currentPin)){
            bankDetails.createBankScreen();
            System.out.print("Do you want to continue (y/n): ");
            char proceed = option.nextLine().charAt(0);
            if (proceed == 'Y' || proceed == 'y') {
                check=true;
            } else {
                check=false;
            }
            while(check) {
                transactionMenu.createTransactionWindow();
                System.out.print("Choose: ");
                int choice = option.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Withdraw amount: ");
                        transaction.withdraw(option.nextInt());
                        break;
                    case 2:
                        System.out.print("Deposit amount: ");
                        transaction.deposit(option.nextInt());
                        break;
                    case 3:
                        transaction.checkBalance();
                        break;
                    default:
                        System.out.println("Invalid operation!");
                }
                System.out.print("Do you want to continue y/n:  ");
                Scanner scanner1 = new Scanner(System.in);
                char progress = scanner1.nextLine().charAt(0);
                if(progress =='N' || progress == 'n'){
                    check = false;
                }
            }
        }
        else {
            System.out.print("Error!, wrong username/password");
        }
    }
}