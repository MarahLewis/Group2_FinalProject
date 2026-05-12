/**
 * Handles alert messages for the restaurant system
 */

public class Alert {

    /**
     * Prints low stock warning for inventory item
     *
     * @param item the inventory item that is low
     */
    public void sendLowStockAlert(Inventory item) {

        System.out.println("LOW STOCK ALERT: " + item.getName() + " has only "
                + item.getQuantity() + " left.");
    }
}
