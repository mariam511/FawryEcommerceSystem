package org.example.services;

import org.example.data.*;
import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalArgumentException("Cart is empty");

        double subtotal = 0;
        List<ShippableItem> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isExpired()) throw new IllegalArgumentException(product.getName() + " is expired");
            subtotal += item.getTotalPrice();

            if (product.requiresShipping() && product instanceof ShippableItem) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((ShippableItem) product);
                }
            }
        }

        double shipping = shippables.isEmpty() ? 0 : ShippingService.shippingProcess(shippables);
        double total = subtotal + shipping;

        customer.reduceBalance(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s        %d\n", item.getQuantity(), item.getProduct().getName(), (int)item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %d\n", (int)subtotal);
        System.out.printf("Shipping         %d\n", (int)shipping);
        System.out.printf("Amount           %d\n", (int)total);
        System.out.printf("Current balance  %d\n", (int)customer.getBalance());
    }
}