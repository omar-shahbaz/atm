package serviceImpl;

import model.TransactionModel;
import service.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionImpl implements Transaction {
    private int balance = 0;

    TransactionModel transactionModel;
    List<TransactionModel> histories= new ArrayList<>();

    int getBalance(){
        return this.balance;
    }

    void setBalance(int balance){
        this.balance = balance;
    }



    @Override
    public double withdraw(int amount) {
        if(balance > 0 && amount > 0 && amount < balance){
            double currentBalance = balance;
            balance = getBalance() - amount;
            System.out.println("Remaining balance: "+balance);
            transactionModel = new TransactionModel();
            transactionModel.date = LocalDate.now().toString();
            transactionModel.time = LocalDateTime.now().toLocalTime().toString();
            transactionModel.transactionName = "Withdraw";
            transactionModel.transactionAmount = amount;
            transactionModel.currentBalance = currentBalance;
            transactionModel.newBalance = balance;

            histories.add(transactionModel);
        } else{
            System.out.println("Your balance is insufficient, please recharge account.");
        }
        return balance;
    }

    @Override
    public double deposit(int amount) {
        int prevBalance;
        transactionModel = new TransactionModel();
        if(balance != 0){
            prevBalance = getBalance();
            transactionModel.currentBalance = getBalance();
            balance = prevBalance + amount;
        } else {
            transactionModel.currentBalance = getBalance();
            setBalance(amount);

        }
        transactionModel.date = LocalDate.now().toString();
        transactionModel.time = LocalDateTime.now().toLocalTime().toString();
        transactionModel.transactionName = "Deposit";
        transactionModel.transactionAmount = amount;
        transactionModel.newBalance = getBalance();

        histories.add(transactionModel);

        System.out.println("New balance: "+ balance);
        return balance;
    }

    @Override
    public double checkBalance() {
        System.out.println("Your current balance is: "+getBalance());
        return getBalance();
    }

    @Override
    public List<TransactionModel> transactionHistory() {
        String historyAlignment = "|     %-12s|     %-12s| %-12s | %-8s| %-15s | %-13s|%n";
        histories.forEach((history) -> {

            System.out.format(historyAlignment, history.date, history.time, history.transactionName,
                    history.transactionAmount, history.currentBalance, history.newBalance);
        });
        if(!histories.isEmpty()) {
            System.out.format("+---------------------------------------------------------------------------------------------+%n");
        }
        return histories;
    }


}
