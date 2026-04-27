public class MenuService {
    private List<MenuItem> menu;
    private InventoryChanges inventoryService;

    public void updateAvailability() {
        for (MenuItem item : menu) {
            boolean canMake = inventoryService.consumeIngredients(item.getIngredientsRequired());
            item.setAvailable(canMake);
        }
    }

    public List<MenuItem> getAvailableMenu() {
        return menu.stream()
                .filter(MenuItem::isAvailable)
                .toList();
    }
}