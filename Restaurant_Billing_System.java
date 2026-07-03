import java.util.ArrayList;
import java.util.Scanner;
class MenuItem {
    int id;
    String name;
    double price;
    MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
class BillItem {
    MenuItem item;
    int quantity;
    BillItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    double getTotal() {
        return item.price * quantity;
    }
}
public class Restaurant_Billing_System {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<MenuItem> menu = new ArrayList<>();
    static ArrayList<BillItem> bill = new ArrayList<>();
    public static void main(String[] args) {
        menu.add(new MenuItem(1, "Burger", 120));
        menu.add(new MenuItem(2, "Pizza", 250));
        menu.add(new MenuItem(3, "Sandwich", 90));
        menu.add(new MenuItem(4, "Pasta", 180));
        menu.add(new MenuItem(5, "Coffee", 60));
        menu.add(new MenuItem(6, "Tea", 30));
        int choice;
        do {
            System.out.println("\n========== RESTAURANT BILLING SYSTEM ==========");
            System.out.println("1. Show Menu");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. View Receipt");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    addItem();
                    break;

                case 3:
                    removeItem();
                    break;
                case 4:
                    printReceipt();
                    break;
                case 5:
                    System.out.println("Thank You! Visit Again.");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }
    static void showMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.printf("%-5s %-15s %-10s\n", "ID", "Item", "Price");
        for (MenuItem m : menu) {
            System.out.printf("%-5d %-15s %.2f\n", m.id, m.name, m.price);
        }
    }
    static void addItem() {
        showMenu();
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        MenuItem selected = null;
        for (MenuItem m : menu) {
            if (m.id == id) {
                selected = m;
                break;
            }
        }
        if (selected == null) {
            System.out.println("Invalid Item ID!");
            return;
        }
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        for (BillItem b : bill) {
            if (b.item.id == id) {
                b.quantity += qty;
                System.out.println("Quantity Updated.");
                return;
            }
        }
        bill.add(new BillItem(selected, qty));
        System.out.println("Item Added Successfully.");
    }
    static void removeItem() {
        if (bill.isEmpty()) {
            System.out.println("No Items in Bill.");
            return;
        }
        System.out.print("Enter Item ID to Remove: ");
        int id = sc.nextInt();
        for (int i = 0; i < bill.size(); i++) {
            if (bill.get(i).item.id == id) {
                bill.remove(i);
                System.out.println("Item Removed Successfully.");
                return;
            }
        }
        System.out.println("Item Not Found.");
    }
    static void printReceipt() {
        if (bill.isEmpty()) {
            System.out.println("No Items Ordered.");
            return;
        }
        double subtotal = 0;
        System.out.println("\n============= RECEIPT =============");
        System.out.printf("%-15s %-8s %-8s %-10s\n", "Item", "Price", "Qty", "Total");
        for (BillItem b : bill) {
            double total = b.getTotal();
            subtotal += total;
            System.out.printf("%-15s %-8.2f %-8d %-10.2f\n",
                    b.item.name,
                    b.item.price,
                    b.quantity,
                    total);
        }
        double gst = subtotal * 0.05;
        double grandTotal = subtotal + gst;
        System.out.println("-----------------------------------------------");
        System.out.printf("Subtotal     : %.2f\n", subtotal);
        System.out.printf("GST (5%%)     : %.2f\n", gst);
        System.out.printf("Grand Total  : %.2f\n", grandTotal);
        System.out.println("-----------------------------------------------");
        System.out.println("Thank You! Visit Again.");
    }
}