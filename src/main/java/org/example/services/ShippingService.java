package org.example.services;
import org.example.data.ShippableItem;
import java.util.*;

public class ShippingService {
    public static double shippingProcess(List<ShippableItem> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCounts = new LinkedHashMap<>();
        Map<String, Double> itemWeights = new LinkedHashMap<>();
        double totalWeight = 0;

        for (ShippableItem item : items) {
            String name = item.getName();
            itemCounts.merge(name, 1, (oldValue, newValue) -> oldValue + newValue);
            itemWeights.merge(name, item.getWeight(), (oldValue, newValue) -> oldValue + newValue);
            totalWeight += item.getWeight();
        }

        for (String name : itemCounts.keySet()) {
            System.out.printf("%dx %s        %dg\n", itemCounts.get(name), name, (int)(itemWeights.get(name) * 1000));
        }

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
        return 30.0; //  fee
    }
}
