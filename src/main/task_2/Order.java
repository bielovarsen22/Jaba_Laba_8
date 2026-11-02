package task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Агрегат Order (Information Expert для підсумкового розрахунку суми, знижки та ПДВ)
 */
public class Order {
    private final int id;
    private final Customer customer;
    private final List<OrderItem> items;
    private String status;

    private double totalAmount;
    private double discountAmount;
    private double taxAmount;
    private double finalAmount;

    // Creator: конструювання агрегату Order одразу з усіма необхідними даними
    public Order(int id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>(items); // Інкапсуляція / Захисне копіювання
        this.status = "New";
        calculateOrderTotals(); // Автоматичний розрахунок під час конструювання
    }

    // Information Expert: бізнес-логіка підрахунку знаходиться у самого володаря даних
    private void calculateOrderTotals() {
        double subtotal = 0.0;
        for (OrderItem item : items) {
            subtotal += item.getItemTotal(); // Делегування до OrderItem
        }
        this.totalAmount = subtotal;

        // Запит коефіцієнта знижки у сутності Customer
        double discountRate = customer.getDiscountRate();
        this.discountAmount = this.totalAmount * discountRate;

        // Обчислення ПДВ 20% та підсумкової суми
        this.taxAmount = (this.totalAmount - this.discountAmount) * 0.20;
        this.finalAmount = this.totalAmount - this.discountAmount + this.taxAmount;
        this.status = "Processed";
    }

    public String generateReceipt() {
        return "Замовлення #" + id + " для " + customer.getName() +
                "\nСума: " + totalAmount + " грн" +
                "\nЗнижка: " + discountAmount + " грн" +
                "\nПДВ: " + taxAmount + " грн" +
                "\nДо сплати: " + finalAmount + " грн";
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); } // Незмінний список
    public double getTotalAmount() { return totalAmount; }
    public double getDiscountAmount() { return discountAmount; }
    public double getTaxAmount() { return taxAmount; }
    public double getFinalAmount() { return finalAmount; }
    public String getStatus() { return status; }
}