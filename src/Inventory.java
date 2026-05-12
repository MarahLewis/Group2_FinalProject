import javax.naming.Name;

/**
 * Represents one inventory ingredient used by the restaurant
 */

public class Inventory {
    private String name;
    private int quantity;
    private int lowThreshold;

    /**
     * Creates a new inventory item
     * @param name ingredient name
     * @param quantity quantity in stock
     * @param lowThreshold low stock warning threshold
     */
    public Inventory(String name, int quantity, int lowThreshold) {
        this.name = name;
        this.quantity = quantity;
        this.lowThreshold = lowThreshold;
    }

    /**
     * Checks whether the inventory item is low in stock
     *
     * @return true if quantity is low
     */

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

    public int getLowThreshold() {
        return lowThreshold;
    }
}
