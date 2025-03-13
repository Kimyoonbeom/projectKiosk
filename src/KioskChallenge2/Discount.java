package KioskChallenge2;

public enum Discount {
    Veteran(0.50), // 국가유공자 10% 할인.
    Soldier(0.03), // 군인 5% 할인
    Student(0.03), // 학생 3% 할인
    Normal(0.0); // 일반인 0% 할인

    private double discountRate;

    Discount(double discountRate){
        this.discountRate = discountRate;
    }

    public double getDiscountRate(){
        return discountRate;
    }
}
