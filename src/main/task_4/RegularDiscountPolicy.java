package task_4;

public class RegularDiscountPolicy implements DiscountPolicy {
    @Override
    public double calculateDiscountRate() {
        return 0.05; // 5% знижки для постійних клієнтів
    }
}