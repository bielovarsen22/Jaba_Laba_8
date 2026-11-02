package task_4;


public class Customer {
    private final int id;
    private final String name;
    private final String email;
    private final String type;
    private final double totalSpent;
    private final DiscountPolicy discountPolicy; // Protected Variations

    public Customer(int id, String name, String email, String type, double totalSpent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
        this.totalSpent = totalSpent;
        // Отримуємо відповідну поліморфну політику через фабрику
        this.discountPolicy = DiscountPolicyFactory.getPolicy(type);
    }

    // Делегування розрахунку знижки поліморфному об'єкту
    public double getDiscountRate() {
        return discountPolicy.calculateDiscountRate();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getType() { return type; }
    public double getTotalSpent() { return totalSpent; }
}