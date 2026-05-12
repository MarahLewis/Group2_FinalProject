import java.util.Arrays;
import java.util.List;

/**
 * Represents a customer order
 */
public class Order {
    private String id;
    private List<MenuItem> items;
    private long createdAt;

    /**
     * Creates a new order
     *
     * @param id order ID
     * @param items menu items in the order
     */
    public Order(String id, List<MenuItem> items) {
        this.id = id;
        this.items = items;
        this.createdAt = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
