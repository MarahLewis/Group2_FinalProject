import java.util.Arrays;
import java.util.List;

public class Order {
    private final String id;
    private final List<MenuItem> items;
    private final long createdAt;

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
