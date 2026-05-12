import java.util.Map;

/**
 * Represents an item that can be ordered from the menu
 */
public class MenuItem {
    private String name;
    private int prepTimeSeconds;
    private Map<String, Integer> ingredientsRequired;
    private boolean available;

    /**
     * Creates a new menu item
     *
     * @param name item name
     * @param prepTimeSeconds preparation time in seconds
     * @param ingredientsRequired ingredients needed to make the item
     */
    public MenuItem(String name,
                    int prepTimeSeconds,
                    Map<String, Integer> ingredientsRequired) {

        this.name = name;
        this.prepTimeSeconds = prepTimeSeconds;
        this.ingredientsRequired = ingredientsRequired;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public int getPrepTimeSeconds() {
        return prepTimeSeconds;
    }

    public Map<String, Integer> getIngredientsRequired() {
        return ingredientsRequired;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}