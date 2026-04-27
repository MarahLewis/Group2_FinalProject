public class KitchenService {
    private List<Kitchen> kitchenList;

    public void assignOrder(Order order) {
        Kitchen leastBusy = kitchenList.stream()
                .min(Comparator.comparingInt(Kitchen::getCurrentLoad))
                .orElseThrow();
        leastBusy.assignOrder(order);
    }
}