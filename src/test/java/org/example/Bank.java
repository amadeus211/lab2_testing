package org.example;

public class Bank {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank(double init_balance) {
        if(init_balance<0){
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }else{
            balance = init_balance;
        }
    }

    public void plus_balance(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Amount must be positive");
        }else{
            balance+=amount;
        }
    }

    public void minus_balance(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void many_operations(int amount_of_operations) {
        for (int i = 0; i < amount_of_operations; i++) {
            double randomAmount = 10 + Math.random() * 10;
            if (i % 2 == 0) {
                plus_balance(randomAmount);
            } else {
                if (randomAmount <= getBalance()) {
                    minus_balance(randomAmount);
                }
            }
        }
    }

}
