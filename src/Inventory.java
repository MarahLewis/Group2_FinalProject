import javax.naming.Name;

public class Inventory {
    private final String name;
    private int quantity;
    private final int lowThreshold;

    public Inventory(String name, int quantity, int lowThreshold) {
        this.name = name;
        this.quantity = quantity;
        this.lowThreshold = lowThreshold;
    }

    public boolean isLow() {
        return quantity <= lowThreshold;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
}
