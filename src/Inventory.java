public class Inventory {
    private String name;
    private int quantity;
    private int lowThreshold;

    public boolean isLow() {
        return quantity <= lowThreshold;
    }

    public float getQuantity() {
    return quantity;
    }

    public void setQuantity(float v) {
    }
}
