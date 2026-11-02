package task_3;
import task_2.Order;
/**
 * Pure Fabrication & Indirection: Інтерфейс сховища замовлень
 */
public interface OrderRepository {
    void save(Order order);
}