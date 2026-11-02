package task_3;
import task_2.Order;
import task_2.Customer;
import task_2.OrderItem;
import java.util.List;

/**
 * Controller (Application Service): координує обробку замовлення
 */
public class OrderController {
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    // Dependency Injection через конструктор (забезпечує Low Coupling)
    public OrderController(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public Order processNewOrder(int customerId, String customerName, String customerEmail, 
                                   String customerType, double totalSpent, 
                                   int orderId, List<OrderItem> items) {
        
        // Створюємо доменні сутності (Information Expert / Creator)
        Customer customer = new Customer(customerId, customerName, customerEmail, customerType, totalSpent);
        Order order = new Order(orderId, customer, items);

        // Зберігаємо замовлення через Indirection (репозиторій)
        orderRepository.save(order);

        // Відправляємо сповіщення через Indirection (сервіс нотифікацій)
        String receiptMessage = order.generateReceipt();
        notificationService.sendEmailNotification(customer.getEmail(), receiptMessage);

        return order;
    }
}