import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Handles inventory updates and ingredient usage
 */
public class InventoryChanges {
    private Map<String, Inventory> inventory = new HashMap<>();
    private Alert alertService;

    /**
     * Creates the inventory service
     *
     * @param alertService alert system for low stock warnings
     */

    public InventoryChanges(Alert alertService) {
        this.alertService = alertService;
    }

    /**
     * Adds new inventory item into the system
     *
     * @param item inventory item to add
     */

    public void addInventory(Inventory item) {
        inventory.put(item.getName(), item);
    }

    /**
     * Consumes ingredients required for an order
     *
     * @param required ingredients needed
     * @return true if inventory is sufficient
     */

    public synchronized boolean consumeIngredients(Map<String, Integer> required) {

        // Check stock first
        for (String item : required.keySet()) {

            Inventory inv = inventory.get(item);

            if (inv == null || inv.getQuantity() < required.get(item)) {;
                return false;
            }
        }

        for (String item : required.keySet()) {

            Inventory inv = inventory.get(item);

            inv.setQuantity(inv.getQuantity() - required.get(item));

            if (inv.isLow()) {
                alertService.sendLowStockAlert(inv);
            }
        }

        return true;
    }

    /**
     * Throws an exception if inventory is insufficient
     *
     * @param required ingredients required
     * @throws InsufficientInventoryException if inventory is too low
     */
    public synchronized void consumeIngredientsOrThrow(Map<String, Integer> required) throws InsufficientInventoryException {
        boolean success = consumeIngredients(required);

        if (!success) {
            throw new InsufficientInventoryException("Not enough inventory to complete order.");
        }
    }

    /**
     * Displays inventory levels
     */
    public void printInventory() {
        System.out.println("\nCurrent Inventory:");

        for (Inventory item : inventory.values()) {
             System.out.println("- " + item.getName() + ": " + item.getQuantity());
        }
    }
}

