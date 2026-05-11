import java.util.List;

public class MenuService {
    private final List<MenuItem> menu;
    private final InventoryChanges inventoryService;

    public MenuService(List<MenuItem> menu,
                       InventoryChanges inventoryService) {

        this.menu = menu;
        this.inventoryService = inventoryService;
    }

    public void updateAvailability() {

        for (MenuItem item : menu) {

            // ONLY CHECK — DO NOT CONSUME
            boolean canMake =
                    inventoryService.canConsume(item.getIngredientsRequired());

            item.setAvailable(canMake);
        }
    }

    public List<MenuItem> getAvailableMenu() {

        updateAvailability();

        return menu.stream()
                .filter(MenuItem::isAvailable)
                .toList();
    }
}