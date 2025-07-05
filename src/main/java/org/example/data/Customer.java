package org.example.data;

public class Customer {
    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public void reduceBalance(double x){
        if(x>balance)throw new IllegalArgumentException("balance is insufficien");
        balance-=x;
    }
}
