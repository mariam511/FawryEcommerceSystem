package org.example.data;

public  abstract class Product {
    private String name;
    private double price;
    private  int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getQuantity() {

        return quantity;
    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();
    public void reduceQuantity(int x){
        if(x>quantity)throw new IllegalArgumentException("this amount is not available");
        quantity-=x;
    }
}
