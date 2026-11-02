package task_2;

/**
 * Сутність Customer (Information Expert щодо своєї знижки)
 */
public class Customer {
    private final int id;
    private final String name;
    private final String email;
    private final String type; // "Regular", "VIP", "New"
    private final double totalSpent;

    public Customer(int id, String name, String email, String type, double totalSpent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.totalSpent = totalSpent;
    }

    // Information Expert: клієнт сам розраховує свою знижку на основі типу
    public double getDiscountRate() {
        if ("VIP".equalsIgnoreCase(type)) {
            return 0.15;
        } else if ("Regular".equalsIgnoreCase(type)) {
            return 0.05;
        } else {
            return 0.0;
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getType() { return type; }
    public double getTotalSpent() { return totalSpent; }
}