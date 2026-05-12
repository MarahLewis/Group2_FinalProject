/**
 * Abstract class for restaurant staff
 */

public abstract class Employee {
    private String name;

    /**
     * Creates an employee
     *
     * @param name employee name
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * Defines employee responsibilities
     */
    public abstract void performRole();

    public String getName() {
        return name;
    }
}
