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
                        transaction.withdraw(option.nextInt());

                        break;
                    case 2:
                        transaction.deposit(option.nextInt());

                        break;
                    case 3:
                        transaction.checkBalance();

                        break;
                    default:
                        System.out.println("Invalid operation!");
                }
                check=false;
            }while (true);
        }
        else {
            System.out.print("Error!, wrong username/password");
        }
    }
}