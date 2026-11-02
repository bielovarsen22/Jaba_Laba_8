package task_3;
import task_2.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Pure Fabrication: Конкретна реалізація сховища для збереження у файл
 */
public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("orders.txt", true))) {
            writer.println("=== Замовлення #" + order.getId() + " ===");
            writer.println("Клієнт: " + order.getCustomer().getName());
            writer.println("Статус: " + order.getStatus());
            writer.println("До сплати: " + order.getFinalAmount() + " грн");
            writer.println("----------------------------------------");
            System.out.println("[БД] Замовлення #" + order.getId() + " успішно збережено у файл orders.txt.");
        } catch (IOException e) {
            System.err.println("[Помилка БД] Не вдалося зберегти замовлення у файл: " + e.getMessage());
        }
    }
}