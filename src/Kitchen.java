/**
 * Represents a kitchen station that prepares orders
 */

public class Kitchen {
    private String name;
    private int currentLoad;

    /**
     * Creates a kitchen
     *
     * @param name kitchen name
     */
    public Kitchen(String name) {
        this.name = name;
        this.currentLoad = 0;
    }

    /**
     * Assigns an order to the kitchen
     *
     * @param order customer order
     */
    public void assignOrder(Order order) {

        int totalPrep = order.getItems()
                .stream()
                .mapToInt(MenuItem::getPrepTimeSeconds)
                .sum();

        currentLoad += totalPrep;

        System.out.println("Order " + order.getId()
                + " assigned to kitchen: " + name
                + " | Added prep time: " + totalPrep + " seconds");
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public String getName() {
        return name;
    }
}
