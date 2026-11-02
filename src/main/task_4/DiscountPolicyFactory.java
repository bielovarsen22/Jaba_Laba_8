package task_4;


public class DiscountPolicyFactory {
    public static DiscountPolicy getPolicy(String type) {
        if ("VIP".equalsIgnoreCase(type)) {
            return new VipDiscountPolicy();
        } else if ("Regular".equalsIgnoreCase(type)) {
            return new RegularDiscountPolicy();
        } else {
            return new NewCustomerDiscountPolicy();
        }
    }
}