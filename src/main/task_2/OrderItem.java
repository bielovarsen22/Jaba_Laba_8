package task_2;

/**
 * Сутність OrderItem (Information Expert для вартості конкретного рядка замовлення)
 */
public class OrderItem {
    private final Product product;
    private final int quantity;

    // Creator / Constructor: створення рядка з обов'язковою наявністю товару та кількості
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Information Expert: обчислення суми для конкретного товару
    public double getItemTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}