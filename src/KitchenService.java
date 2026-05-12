import java.util.Comparator;
import java.util.List;

/**
 * Handles kitchen assignment operations
 */
public class KitchenService {
    private List<Kitchen> kitchenList;

    /**
     * Creates the kitchen service
     *
     * @param kitchenList available kitchens
     */
    public KitchenService(List<Kitchen> kitchenList) {
        this.kitchenList = kitchenList;
    }

    /**
     * Assigns an order to the least busy kitchen
     *
     * @param order customer order
     */
    public void assignOrder(Order order) {

        Kitchen leastBusy = kitchenList.stream()
                .min(Comparator.comparingInt(Kitchen::getCurrentLoad))
                .orElseThrow();

        leastBusy.assignOrder(order);
    }
}