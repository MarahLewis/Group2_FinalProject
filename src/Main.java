import java.util.*;

/**
 * Main driver class for the restaurant management system
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Alert + Inventory
        Alert alert = new Alert();

        InventoryChanges inventoryService = new InventoryChanges(alert);

        inventoryService.addInventory(new Inventory("Bun", 10, 2));

        inventoryService.addInventory(new Inventory("Patty", 10, 2));

        inventoryService.addInventory(new Inventory("Lettuce", 15, 3));

        inventoryService.addInventory(new Inventory("Potato", 20, 5));

        inventoryService.addInventory(new Inventory("Chicken", 10, 2));

        inventoryService.addInventory(new Inventory("Tomato", 10, 2));

        //Burger Ingredients
        Map<String, Integer> burgerIngredients = new HashMap<>();

        burgerIngredients.put("Bun", 1);
        burgerIngredients.put("Patty", 1);
        burgerIngredients.put("Lettuce", 1);

        //Fries Ingredients
        Map<String, Integer> friesIngredients = new HashMap<>();

        friesIngredients.put("Potato", 3);

        //Chicken Sandwich Ingredients
        Map<String, Integer> chickenIngredients = new HashMap<>();

        chickenIngredients.put("Bun", 1);
        chickenIngredients.put("Chicken", 1);
        chickenIngredients.put("Lettuce", 1);
        chickenIngredients.put("Tomato", 1);

        //Salad Ingredients
        Map<String, Integer> saladIngredients = new HashMap<>();

        saladIngredients.put("Lettuce", 2);
        saladIngredients.put("Tomato", 2);

        //Menu Items
        MenuItem burger = new MenuItem("Burger", 300, burgerIngredients);

        MenuItem fries = new MenuItem("Fries", 100, friesIngredients);

        MenuItem chickenSandwich = new MenuItem("Chicken Sandwich", 420, chickenIngredients);

        MenuItem salad = new MenuItem("Salad", 120, saladIngredients);

        //Menu List
        List<MenuItem> menuItems = Arrays.asList(burger, fries, chickenSandwich, salad);

        MenuService menuService = new MenuService(menuItems);

        //Kitchens
        Kitchen kitchen1 = new Kitchen("Kitchen 1");
        Kitchen kitchen2 = new Kitchen("Kitchen 2");

        KitchenService kitchenService = new KitchenService(Arrays.asList(kitchen1, kitchen2));

        //Order Service
        OrderService orderService = new OrderService(inventoryService, kitchenService);

        //Kitchen Staff
        KitchenStaff staff = new KitchenStaff("Kitchen Staff 1");

        staff.performRole();

        int orderNumber = 1;

        //Main Program Loop
        while (true) {
            System.out.println("\nRestaurant Ordering System");

            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");

            //Error Handling
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            //View Menu
            if (choice == 1) {
                menuService.printMenu();
            }

            //Place Order
            else if (choice == 2) {
                menuService.printMenu();

                System.out.print("Enter item number to order: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input.");
                    scanner.next();
                    continue;
                }

                int itemChoice = scanner.nextInt();

                if (itemChoice < 1 || itemChoice > menuItems.size()) {
                    System.out.println ("Invalid menu item.");
                    continue;
                }

                MenuItem selectedItem = menuItems.get(itemChoice - 1);

                Order order = new Order("ORD-" + orderNumber, List.of(selectedItem));

                boolean success = orderService.placeOrder(order, "Customer");

                if (success) {
                    System.out.println("Order places successfully: " + selectedItem.getName());
                    orderNumber++;
                }

                else {
                    System.out.println("Order failed. Not enough inventory.");
                }
            }

            //View Inventory
            else if (choice == 3) {
                inventoryService.printInventory();
            }

            //Exit
            else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            //Invalid Choice
            else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}