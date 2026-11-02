package task_3;
import task_2.Product;
import task_2.OrderItem;
import task_2.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Thin Console UI: Шар інтерфейсу користувача (тільки введення/виведення)
 */
public class ConsoleUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Оформлення замовлення (Інтернет-магазин) ===");
        
        System.out.print("Введіть ім'я клієнта: ");
        String name = scanner.nextLine();
        
        System.out.print("Введіть тип клієнта (New / Regular / VIP): ");
        String customerType = scanner.nextLine();

        // Формуємо початкові дані товарів для демонстрації варіанта
        Product p1 = new Product(1, "Ноутбук", 30000.0, "Electronics");
        Product p2 = new Product(2, "Мишка", 800.0, "Accessories");

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(p1, 1));
        items.add(new OrderItem(p2, 2));

        // Створюємо інфраструктурні залежності (Pure Fabrication)
        OrderRepository repository = new FileOrderRepository();
        NotificationService notifier = new EmailNotificationService();

        // Ініціалізуємо Controller та передаємо йому управління
        OrderController controller = new OrderController(repository, notifier);
        
        Order processedOrder = controller.processNewOrder(
                1, name, "client@example.com", customerType, 15000.0, 101, items
        );

        // Виводимо рахунок у консоль через UI
        System.out.println("\n--- ЗГЕНЕРОВАНИЙ РАХУНОК ---");
        System.out.println(processedOrder.generateReceipt());
        
        scanner.close();
    }
}