import authUser.UserAuth;
import service.Transaction;
import serviceImpl.TransactionImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Transaction transaction = new TransactionImpl();
        boolean check = true;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String currentUser = scanner.nextLine();
        System.out.print("Pin: ");
        Integer currentPin = scanner.nextInt();

        Scanner option = new Scanner(System.in);

        if(UserAuth.USERNAME.equals(currentUser) && UserAuth.PIN.equals(currentPin)){
            System.out.println("Welcome! "+currentUser);
            do {
                System.out.println("Choose action to perform: ");
                System.out.println("1. Withdraw Money");
                System.out.println("2. Deposit Money");
                System.out.println("3. Check Balance");
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
            }while (check);
        }
        else {
            System.out.print("Error!, wrong username/password");
        }
    }
}