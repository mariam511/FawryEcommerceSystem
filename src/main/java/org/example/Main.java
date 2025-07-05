package org.example;

import org.example.data.*;
import org.example.services.CheckoutService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            //Normal checkout
            System.out.println("\n=====Test1=====");
            Customer customer1 = new Customer("Mariam", 1000);
            Cart cart1 = new Cart();
            Product cheese1 = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(2), 0.2);
            Product biscuits1 = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(2), 0.7);
            cart1.addProduct(cheese1, 2);
            cart1.addProduct(biscuits1, 1);
            CheckoutService.checkout(customer1, cart1);

            //Cart is empty
            System.out.println("\n=====Test2=====");
            Customer customer2 = new Customer("Ali", 500);
            Cart cart2 = new Cart();
            CheckoutService.checkout(customer2, cart2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            //Expired Product
            System.out.println("\n=====Test3=====");
            Customer customer3 = new Customer("Sara", 1000);
            Cart cart3 = new Cart();
            Product expiredCheese = new Cheese("Old Cheese", 100, 5, LocalDate.now().minusDays(1), 0.2);
            cart3.addProduct(expiredCheese, 1);
            CheckoutService.checkout(customer3, cart3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            //Not enough quantity in stock
            System.out.println("\n=====Test4=====");
            Customer customer4 = new Customer("Omar", 1000);
            Cart cart4 = new Cart();
            Product fewTVs = new TV("TV", 5000, 1, 3.5);
            cart4.addProduct(fewTVs, 2);
            CheckoutService.checkout(customer4, cart4);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            //Insufficient balance
            System.out.println("\n=====Test5=====");
            Customer customer5 = new Customer("Laila", 100);
            Cart cart5 = new Cart();
            Product cheese2 = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
            cart5.addProduct(cheese2, 2);
            CheckoutService.checkout(customer5, cart5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
