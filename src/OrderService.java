/**
 * Handles customer order processing
 */
public class OrderService implements OrderProcessor{
    private InventoryChanges inventoryService;
    private KitchenService kitchenService;

    /**
     * Creates the order service
     *
     * @param inventoryService inventory manager
     * @param kitchenService kitchen assignment manager
     */
    public OrderService(InventoryChanges inventoryService,
                        KitchenService kitchenService) {

        this.inventoryService = inventoryService;
        this.kitchenService = kitchenService;
    }

    /**
     * Places a customer order
     *
     * @param order customer order
     * @return true if successful
     */
    @Override
    public boolean placeOrder(Order order) {

        // Consume ingredients for each item
        for (MenuItem item : order.getItems()) {

            boolean success = inventoryService.consumeIngredients(
                    item.getIngredientsRequired()
            );

            if (!success) {
                return false;
            }
        }

        kitchenService.assignOrder(order);

        return true;
    }

    /**
     * Overloaded order placement method
     *
     * @param order customer order
     * @param customerName customer name
     * @return true if successful
     */
    public boolean placeOrder(Order order, String customerName) {
        System.out.println("Placing order for: " + customerName);
        return placeOrder(order);
    }
}