import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Product {
    int id;
    String name;
    double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class Online_Shopping_Cart {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static HashMap<Integer, Integer> cart = new HashMap<>();
    public static void main(String[] args) {
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Mobile", 18000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Keyboard", 1500));
        products.add(new Product(5, "Mouse", 700));
        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println(" ONLINE SHOPPING CART ");
            System.out.println("==================================");
            System.out.println("1. View Products");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Item");
            System.out.println("5. Calculate Total");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    calculateTotal();
                    break;
                case 6:
                    System.out.println("Thank You for Shopping!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 6);
    }
    static void viewProducts() {
        System.out.println("\n-------------------------------------");
        System.out.printf("%-5s %-20s %-10s\n", "ID", "Product", "Price");
        System.out.println("-------------------------------------");
        for (Product p : products) {
            System.out.printf("%-5d %-20s %.2f\n",
                    p.id,
                    p.name,
                    p.price);
        }
    }
    static void addToCart() {
        viewProducts();
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        Product product = null;
        for (Product p : products) {
            if (p.id == id) {
                product = p;
                break;
            }
        }
        if (product == null) {
            System.out.println("Invalid Product ID!");
            return;
        }
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        if (qty <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }
        if (cart.containsKey(id))
            cart.put(id, cart.get(id) + qty);
        else
            cart.put(id, qty);
        System.out.println("Item Added Successfully.");
    }
    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }
        System.out.println("\n-----------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s\n",
                "Product", "Price", "Qty", "Total");
        System.out.println("-----------------------------------------------");
        for (Integer id : cart.keySet()) {
            int qty = cart.get(id);
            for (Product p : products) {
                if (p.id == id) {
                    double total = p.price * qty;
                    System.out.printf("%-20s %-10.2f %-10d %-10.2f\n",
                            p.name,
                            p.price,
                            qty,
                            total);
                }
            }
        }
    }
    static void removeItem() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }
        System.out.print("Enter Product ID to Remove: ");
        int id = sc.nextInt();
        if (cart.containsKey(id)) {
            cart.remove(id);
            System.out.println("Item Removed Successfully.");
        } else {
            System.out.println("Product Not Found.");
        }
    }
    static void calculateTotal() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }
        double totalAmount = 0;
        for (Integer id : cart.keySet()) {
            int qty = cart.get(id);
            for (Product p : products) {
                if (p.id == id) {
                    totalAmount += p.price * qty;
                }
            }
        }
        System.out.println("--------------------------------");
        System.out.printf("Total Amount : %.2f\n", totalAmount);
        System.out.println("--------------------------------");
        
    }

}