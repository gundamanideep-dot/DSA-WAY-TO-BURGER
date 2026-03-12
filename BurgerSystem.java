import java.util.*;

// Burger Class
class Burger {
    String name;
    int price;

    Burger(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " - ₹" + price;
    }
}

public class BurgerSystem {

    // Hashing: Menu stored in HashMap
    static HashMap<String, Burger> menu = new HashMap<>();

    // Linked List for Cart
    static LinkedList<Burger> cart = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Adding menu items
        menu.put("veg", new Burger("Classic Veg Burger", 99));
        menu.put("chicken", new Burger("Chicken Burger", 199));
        menu.put("cheese", new Burger("Cheese Burst Burger", 149));
        menu.put("combo", new Burger("Family Combo", 399));
        menu.put("cola", new Burger("Coca Cola", 49));

        while (true) {

            System.out.println("\n===== WAY TO BURGER MENU =====");
            System.out.println("1. View Menu");
            System.out.println("2. Search Burger");
            System.out.println("3. Add to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Sort Burgers by Price");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayMenu();
                    break;

                case 2:
                    System.out.print("Enter burger name to search: ");
                    String name = sc.nextLine();
                    searchBurger(name);
                    break;

                case 3:
                    System.out.print("Enter burger key (veg/chicken/cheese/combo/cola): ");
                    String key = sc.nextLine();
                    addToCart(key);
                    break;

                case 4:
                    viewCart();
                    break;

                case 5:
                    sortBurgers();
                    break;

                case 6:
                    System.out.println("Thank you for visiting!");
                    return;
            }
        }
    }

    // Display Menu
    static void displayMenu() {
        System.out.println("\nAvailable Burgers:");
        for (Burger b : menu.values()) {
            System.out.println(b);
        }
    }

    // Searching (Linear Search)
    static void searchBurger(String name) {

        for (Burger b : menu.values()) {

            if (b.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Burger Found: " + b);
                return;
            }
        }

        System.out.println("Burger not found.");
    }

    // Add to Cart (LinkedList)
    static void addToCart(String key) {

        if (menu.containsKey(key)) {
            cart.add(menu.get(key));
            System.out.println(menu.get(key).name + " added to cart.");
        } else {
            System.out.println("Invalid item.");
        }
    }

    // View Cart
    static void viewCart() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nCart Items:");
        int total = 0;

        for (Burger b : cart) {
            System.out.println(b);
            total += b.price;
        }

        System.out.println("Total Price: ₹" + total);
    }

    // Sorting (by price)
    static void sortBurgers() {

        List<Burger> list = new ArrayList<>(menu.values());

        list.sort(Comparator.comparingInt(b -> b.price));

        System.out.println("\nBurgers Sorted by Price:");

        for (Burger b : list) {
            System.out.println(b);
        }
    }
}