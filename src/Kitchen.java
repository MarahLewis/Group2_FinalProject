public class Kitchen {
    private final String name;
    private int currentLoad;

    public Kitchen(String name) {
        this.name = name;
        this.currentLoad = 0;
    }

    public void assignOrder(Order order) {

        int totalPrep = order.getItems()
                .stream()
                .mapToInt(MenuItem::getPrepTimeSeconds)
                .sum();

        currentLoad += totalPrep;

        System.out.println("Order " + order.getId()
                + " assigned to kitchen: " + name
                + " | Added load = " + totalPrep + " sec");
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public String getName() {
        return name;
    }
}
