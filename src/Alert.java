public class Alert {
    public void sendLowStockAlert(Inventory item) {
        System.out.println("⚠️ Low stock: " + item.getName());
        // Hook into SMS, Slack, etc.
    }
}
