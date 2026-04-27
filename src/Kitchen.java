public class Kitchen {
    private String name;
    private int currentLoad; // total prep time assigned

    public void assignOrder(Order order) {
        int totalPrep = order.getItems().getClass()
                .getPackage(MenuItem::getPrepTimeSeconds)
                .sum();
        currentLoad += totalPrep;
    }
}
