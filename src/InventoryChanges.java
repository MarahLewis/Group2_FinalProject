import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryChanges {
    private final Map<String, Inventory> inventory = new ConcurrentHashMap<>();
    private final Alert alertService;

    public InventoryChanges(Alert alertService) {
        this.alertService = alertService;
    }

    public void addInventory(Inventory item) {
        inventory.put(item.getName(), item);
    }

    public void printInventory() {
        System.out.println("\n=== INVENTORY STATUS ===");
        for (Inventory inv : inventory.values()) {
            System.out.println(inv.getName() + " : " + inv.getQuantity());
        }
    }

    public synchronized boolean consumeIngredients(Map<String, Integer> required) {

        // Check stock first
        for (Map.Entry<String, Integer> entry : required.entrySet()) {

            String itemName = entry.getKey();
            int requiredQty = entry.getValue();

            Inventory inv = inventory.get(itemName);

            if (inv == null) {
                System.out.println("Missing inventory item: " + itemName);
                return false;
            }

            if (inv.getQuantity() < requiredQty) {
                System.out.println("Not enough stock for: " + itemName);
                return false;
            }
        }

        // Consume stock
        for (Map.Entry<String, Integer> entry : required.entrySet()) {

            String itemName = entry.getKey();
            int requiredQty = entry.getValue();

            Inventory inv = inventory.get(itemName);

            inv.setQuantity(inv.getQuantity() - requiredQty);

            if (inv.isLow()) {
                alertService.sendLowStockAlert(inv);
            }
        }

        return true;
    }

    public synchronized boolean canConsume(Map<String, Integer> required) {

        for (Map.Entry<String, Integer> entry : required.entrySet()) {

            String itemName = entry.getKey();
            int requiredQty = entry.getValue();

            Inventory inv = inventory.get(itemName);

            if (inv == null || inv.getQuantity() < requiredQty) {
                return false;
            }
        }

        return true;
    }
}

