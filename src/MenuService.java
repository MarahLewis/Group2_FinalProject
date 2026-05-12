import java.util.List;

/**
 * Handles menu operations and displays menu items
 */
public class MenuService {
    private List<MenuItem> menu;

    /**
     * Creates the menu service
     *
     * @param menu list of menu items
     */
    public MenuService(List<MenuItem> menu) {

        this.menu = menu;
    }

    /**
     * Returns all menu items
     *
     * @return menu item list
     */
    public List<MenuItem> getMenu() {
        return menu;
    }

    /**
     * Displays the menu to user
     */
    public void printMenu() {
        System.out.println("\nMenu:");

        for (int i = 0; i < menu.size(); i++) {

            MenuItem item = menu.get(i);

            System.out.println((i +1) + ". " + item.getName() + " - Prep Time: " + item.getPrepTimeSeconds() + " seconds");
        }
    }

}