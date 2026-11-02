package task_4;

public class NewCustomerDiscountPolicy implements DiscountPolicy {
    @Override
    public double calculateDiscountRate() {
        return 0.0; // 0% знижки для нових клієнтів
    }
}