import java.util.HashMap;
import java.util.Map;

public class InventoryChanges {
    private Map<String, Inventory> inventory = new HashMap<>();
    private Alert alertService;

    public synchronized boolean consumeIngredients(Map<String, Integer> required) {
        for (String item : required.keySet()) {
            Inventory inv = inventory.get(item);
            if (inv.getQuantity() < required.get(item)) {
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
}

