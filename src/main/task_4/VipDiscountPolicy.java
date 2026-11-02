package task_4;

public class VipDiscountPolicy implements DiscountPolicy {
    @Override
    public double calculateDiscountRate() {
        return 0.15; // 15% знижки для VIP-клієнтів
    }
}