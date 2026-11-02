package task_3;

/**
 * Pure Fabrication: Реалізація сервісу відправки email
 */
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendEmailNotification(String email, String message) {
        System.out.println("[Email] Відправка повідомлення на " + email + ":\n" + message);
    }
}