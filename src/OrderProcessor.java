/**
 * Defines behavior for classes that process orders
 */
public interface OrderProcessor {

    /**
     * Places an order in the system
     *
     * @param order customer order
     * @return true if the order was placed successfully
     */
    boolean placeOrder(Order order);
}
