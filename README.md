# Fawry Rise E-Commerce System

A clean, modular Java application developed in response to the Fawry Rise Full Stack Development Internship Challenge.  
This project demonstrates core object-oriented principles through the simulation of an e-commerce system with checkout, inventory control, and shipping handling.

**Overview**

This system models real-world e-commerce scenarios:
- Managing multiple types of products (perishable/non-perishable, shippable/non-shippable)
- Validating inventory and expiry
- Handling customer carts and checkout logic
- Shipping integration with interface-based design

All features are implemented using pure Java and follow a layered, maintainable architecture.

---

**Core Features**

**Product Modeling**
- Products include basic attributes: name, price, quantity
- Some products can expire (e.g., Cheese, Biscuits)
- Some products require shipping and specify weight (e.g., TV, Cheese)

**Cart Operations**
- Customers can add products to the cart with quantity checks
- Prevents adding expired products or exceeding stock limits

**Checkout Process**
- Validates:
  - Non-empty cart
  - Product availability and freshness
  - Customer’s account balance
- Calculates:
  - Order subtotal
  - Shipping fees (if applicable)
  - Total amount paid
  - Updated customer balance
- Sends shippable items to a `ShippingService`

**ShippingService Integration**
- Accepts a list of shippable items implementing a shared interface
- Aggregates item weights and formats a shipping summary for output

---

**Use Case Coverage**

This project includes full demonstration of the following scenarios:

| Scenario                          | Covered |
|-----------------------------------|---------|
| Standard checkout with shipping   | Yes ✅  |
| Cart is empty                     | Yes ✅  |
| Product is expired                | Yes ✅  |
| Quantity exceeds available stock  | Yes ✅  |
| Insufficient customer balance     | Yes ✅  |

Each scenario is implemented in `Main.java` with printed output verifying behavior.

---

**Sample Console Output**

```
** Shipment notice ** 
2x Cheese        400g     
1x Biscuits      700g 
Total package weight 1.1kg 

** Checkout receipt ** 
2x Cheese        200 
1x Biscuits      150 
---------------------- 
Subtotal         350
Shipping         30
Amount           380
---

**Project Structure**

```
src/
└── main/
    └── java/
        └── org/
            └── example/
                ├── data/       → Models: Product, Cart, Customer, Subclasses
                ├── services/   → Services: CheckoutService, ShippingService
                └── Main.java    → Main File with use case scenarios
```

---

**OOP Design Highlights**

- **Abstraction**: Product is abstract with specialized implementations
- **Inheritance**: Cheese, TV, etc. inherit and extend behavior
- **Interfaces**: ShippableItem interface allows polymorphic shipping logic
- **Encapsulation**: All fields are private with validation
- **Polymorphism**: Unified handling for different product types

---

**Assumptions**

- Product weights are in kilograms (converted to grams in shipping output)
- Shipping cost is fixed at 30 EGP if at least one item is shippable
- All processing is in-memory; no database or persistence layer is used
- Expiry validation checks against the system's current date

---

**Setup & Execution**

1. Open the project using IntelliJ IDEA (or any Java-compatible IDE)
2. Ensure JDK 17 or higher is configured
3. Run the `Main` class inside the `com.fawry.run` package

---

**License**

This project was developed as part of the Fawry Rise Internship Challenge  
and is intended solely for demonstration and evaluation purposes.
