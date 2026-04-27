public class OrderService {
    private InventoryChanges inventoryService;
    private KitchenService staffService;

    public boolean placeOrder(Order order) {
        for (MenuItem item : order.getItems()) {
            boolean success = inventoryService.consumeIngredients(item.getIngredientsRequired());
            if (!success) {
                return false;
            }
        }

        staffService.assignOrder(order);
        return true;
    }
}