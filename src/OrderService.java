public class OrderService {
    private final InventoryChanges inventoryService;
    private final KitchenService kitchenService;

    public OrderService(InventoryChanges inventoryService,
                        KitchenService kitchenService) {

        this.inventoryService = inventoryService;
        this.kitchenService = kitchenService;
    }

    public boolean placeOrder(Order order) {

        // Consume ingredients for each item
        for (MenuItem item : order.getItems()) {

            boolean success = inventoryService.consumeIngredients(
                    item.getIngredientsRequired()
            );

            if (!success) {
                System.out.println("Order failed: " + item.getName());
                return false;
            }
        }

        kitchenService.assignOrder(order);

        System.out.println("Order placed successfully: " + order.getId());

        return true;
    }
}