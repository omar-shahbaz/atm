import authUser.UserAuth;
import service.Transaction;
import serviceImpl.TransactionImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        Transaction transaction = new TransactionImpl();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String currentUser = scanner.nextLine();
        System.out.print("Pin: ");
        Integer currentPin = scanner.nextInt();

        Scanner option = new Scanner(System.in);

        if(UserAuth.USERNAME.equals(currentUser) && UserAuth.PIN.equals(currentPin)){
            System.out.println("Welcome! "+currentUser);
            do {
                switch (option.nextInt()) {
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
            }while (true);
        }
        else {
            System.out.print("Error!, wrong username/password");

        }
    }
}