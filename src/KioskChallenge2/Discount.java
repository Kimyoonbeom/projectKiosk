package KioskChallenge2;

public enum Discount {
    Veteran(0.10), // 국가유공자 10% 할인.
    Soldier(0.05), // 군인 5% 할인
    Student(0.03), // 학생 3% 할인
    Normal(0.00); // 일반인 0% 할인

    private final double discountRate;

    Discount(double discountRate){
        this.discountRate = discountRate;
    }

    public double getDiscountRate(){
        return discountRate;
    }
}
