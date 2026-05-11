import java.util.Map;

public class MenuItem {
    private final String name;
    private final int prepTimeSeconds;
    private final Map<String, Integer> ingredientsRequired;
    private boolean available;

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