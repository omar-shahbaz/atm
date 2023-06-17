package serviceImpl;

import service.Transaction;
public class TransactionImpl implements Transaction {
    private int balance = 0;
    int getBalance(){
        return this.balance;
    }

    void setBalance(int balance){
        this.balance = balance;
    }



    @Override
    public double withdraw(int amount) {
        if(balance > 0 && amount > 0 && amount < balance){
            balance = getBalance() - amount;
            System.out.println("Remaining balance: "+balance);
        } else{
            System.out.println("Your balance is insufficient, please recharge account.");
        }
        return balance;
    }

    @Override
    public double deposit(int amount) {
        int prevBalance;
        if(balance != 0){
            prevBalance = getBalance();
            balance = prevBalance + amount;
        } else {
            setBalance(amount);
        }


        System.out.println("New balance: "+ balance);
        return balance;
    }

    @Override
    public double checkBalance() {
        System.out.println("Your current balance is: "+getBalance());
        return getBalance();
    }


}
