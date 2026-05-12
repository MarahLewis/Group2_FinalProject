/**
 * Custom exception used when inventory is too low to complete an order
 */

public class InsufficientInventoryException extends Exception {

    /**
     * Creates a new inventory exception
     *
     * @param message exception message
     */
    public InsufficientInventoryException(String message) {
        super(message);
    }
}
