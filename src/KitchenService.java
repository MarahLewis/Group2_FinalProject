import java.util.Comparator;
import java.util.List;

public class KitchenService {
    private final List<Kitchen> kitchenList;

    public KitchenService(List<Kitchen> kitchenList) {
        this.kitchenList = kitchenList;
    }

    public void assignOrder(Order order) {

        Kitchen leastBusy = kitchenList.stream()
                .min(Comparator.comparingInt(Kitchen::getCurrentLoad))
                .orElseThrow();

        leastBusy.assignOrder(order);
    }
}