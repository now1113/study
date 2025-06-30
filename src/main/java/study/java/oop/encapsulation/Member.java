package study.java.oop.encapsulation;

public class Member {
    private final String name;
    private Grade grade;
    private int totalPurchaseAmount;

    public Member(String name, Grade grade, int totalPurchaseAmount) {
        this.name = name;
        this.grade = grade;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public void addPurchaseAmount(int purchaseAmount) {
        this.totalPurchaseAmount += purchaseAmount;
        // 내부에서 등급 조건 확인
        evaluateGrade();
    }

    private void evaluateGrade() {
        if (this.totalPurchaseAmount > 1_000_000) {
            this.grade = Grade.Vip;
        } else if (this.totalPurchaseAmount > 500_000) {
            this.grade = Grade.Premium;
        } else {
            this.grade = Grade.Basic;
        }
    }

    public Grade getGrade() {
        return grade;
    }
}
