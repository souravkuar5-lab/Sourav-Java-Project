import java.util.ArrayList;
import java.util.Scanner;

// Product class to store product details
class Product {

    // Product attributes
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    // Constructor to initialize product details
    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter method to update quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display product details
    public void displayProduct() {
        System.out.println(
                productId + " | " +
                productName + " | Price: ₹" + price +
                " | Quantity: " + quantity +
                " | Total: ₹" + (price * quantity));
    }
}

// Cart class to manage shopping cart operations
class Cart {

    // ArrayList to store products
    private ArrayList<Product> products = new ArrayList<>();

    // Add product to cart
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully.");
    }

    // Remove product using product ID
    public void removeProduct(int productId) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                System.out.println("Product removed successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Search product by ID
    public void searchProduct(int productId) {

        for (Product p : products) {

            if (p.getProductId() == productId) {
                System.out.println("\nProduct Found:");
                p.displayProduct();
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Update product quantity
    public void updateQuantity(int productId, int newQuantity) {

        for (Product p : products) {

            if (p.getProductId() == productId) {
                p.setQuantity(newQuantity);
                System.out.println("Quantity updated successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // Calculate total amount of cart
    public double calculateTotal() {

        double total = 0;

        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }

        return total;
    }

    // Display all products in cart
    public void displayCart() {

        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n===== CART ITEMS =====");

        for (Product p : products) {
            p.displayProduct();
        }
    }

    // Generate final bill
    public void generateBill() {

        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        // Calculate total amount
        double total = calculateTotal();

        // Apply 10% discount
        double discount = total * 0.10;

        // Amount after discount
        double afterDiscount = total - discount;

        // Apply 5% tax
        double tax = afterDiscount * 0.05;

        // Final bill amount
        double finalAmount = afterDiscount + tax;

        System.out.println("\n========== FINAL BILL ==========");

        displayCart();

        System.out.println("\nTotal Amount      : ₹" + total);
        System.out.println("Discount (10%)    : ₹" + discount);
        System.out.println("Tax (5%)          : ₹" + tax);
        System.out.println("--------------------------------");
        System.out.println("Final Amount      : ₹" + finalAmount);
        System.out.println("================================");
    }
}

// Main class
public class ShoppingCartSystem {

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Create cart object
        Cart cart = new Cart();

        int choice;

        // Menu-driven loop
        do {

            System.out.println("\n===== E-COMMERCE SHOPPING CART =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Search Product");
            System.out.println("5. Update Quantity");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Product
                case 1:

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Product Price: ₹");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    Product product = new Product(id, name, price, quantity);

                    cart.addProduct(product);

                    break;

                // Remove Product
                case 2:

                    System.out.print("Enter Product ID to Remove: ");
                    int removeId = sc.nextInt();

                    cart.removeProduct(removeId);

                    break;

                // View Cart
                case 3:

                    cart.displayCart();

                    break;

                // Search Product
                case 4:

                    System.out.print("Enter Product ID to Search: ");
                    int searchId = sc.nextInt();

                    cart.searchProduct(searchId);

                    break;

                // Update Quantity
                case 5:

                    System.out.print("Enter Product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();

                    cart.updateQuantity(updateId, newQuantity);

                    break;

                // Generate Bill
                case 6:

                    cart.generateBill();

                    break;

                // Exit Program
                case 7:

                    System.out.println("Thank You!");
                    break;

                // Invalid Choice
                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        // Close scanner
        sc.close();
    }
}