package org.example.data;
import java.util.*;

public class Cart {
    private List<CartItem>items =new ArrayList<>();
    public void addProduct(Product product,int quantity){
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("this amount is not available");

        }
        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
    }
    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
