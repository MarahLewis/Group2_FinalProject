import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Alert & Inventory
        Alert alert = new Alert();
        InventoryChanges inventoryService =
                new InventoryChanges(alert);
        inventoryService.addInventory(
                new Inventory("Bun", 10, 2));
        inventoryService.addInventory(
                new Inventory("Patty", 10, 2));
        inventoryService.addInventory(
                new Inventory("Lettuce", 10, 2));
        inventoryService.addInventory(
                new Inventory("Potato", 20, 5));

        //Menu Items
        Map<String, Integer> burgerIngredients = new HashMap<>();
        burgerIngredients.put("Bun", 1);
        burgerIngredients.put("Patty", 1);
        burgerIngredients.put("Lettuce", 1);

        MenuItem burger =
                new MenuItem("Burger", 300, burgerIngredients);

        Map<String, Integer> friesIngredients = new HashMap<>();
        friesIngredients.put("Potato", 3);

        MenuItem fries =
                new MenuItem("Fries", 180, friesIngredients);

        List<MenuItem> menu = Arrays.asList(burger, fries);

        //Menu Service
        MenuService menuService =
                new MenuService(menu, inventoryService);

        System.out.println("=== AVAILABLE MENU ===");

        for (MenuItem item : menuService.getAvailableMenu()) {
            System.out.println(item.getName());
        }

        // Kitchens
        Kitchen kitchen1 = new Kitchen("Kitchen-A");
        Kitchen kitchen2 = new Kitchen("Kitchen-B");

        KitchenService kitchenService =
                new KitchenService(Arrays.asList(kitchen1, kitchen2));

        //Order Service
        OrderService orderService =
                new OrderService(inventoryService, kitchenService);

        //Place Order
        Order order1 = new Order(
                "ORD-1001",
                Arrays.asList(burger, fries)
        );

        orderService.placeOrder(order1);

        inventoryService.printInventory();

        //Place another order
        Order order2 = new Order(
                "ORD-1002",
                Arrays.asList(
                        burger,
                        burger,
                        fries
                )
        );

        orderService.placeOrder(order2);

        inventoryService.printInventory();
    }
}