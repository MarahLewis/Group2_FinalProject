/**
 * Represents kitchen staff employees
 */

public class KitchenStaff extends Employee{

    /**
     * Creates a kitchen staff employee
     *
     * @param name employee name
     */
    public KitchenStaff(String name) {
        super(name);
    }

    /**
     * Displays the employee role
     */
    @Override
    public void performRole() {
        System.out.println(getName() + " is preparing orders in the kitchen.");
    }
}
