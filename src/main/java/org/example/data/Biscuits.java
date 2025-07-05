package org.example.data;

import java.time.LocalDate;

public class Biscuits extends Product implements ShippableItem {
    private LocalDate expireDate;
    private double weight;

    public Biscuits(String name, double price, int quantity, LocalDate expireDate, double weight) {
        super(name, price, quantity);
        this.expireDate = expireDate;
        this.weight = weight;
    }

    @Override
    public  boolean isExpired(){
        return LocalDate.now().isAfter(expireDate);
    }
    @Override
    public  boolean requiresShipping(){
        return true;
    }
    @Override
    public double getWeight(){
        return weight;
    }
}
