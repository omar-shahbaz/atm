package service;

import java.util.List;

public interface Transaction {

    double withdraw(int amount);

    double deposit(int amount);

    double checkBalance();

}
