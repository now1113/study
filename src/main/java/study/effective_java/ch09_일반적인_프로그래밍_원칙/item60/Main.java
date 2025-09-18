package study.effective_java.ch09_일반적인_프로그래밍_원칙.item60;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);      // 0.30000000000000004
        System.out.println(1.00 - 0.90);    // 0.09999999999999998
        System.out.println(1.03 - 0.41);    // 0.6200000000000001

        System.out.println(new BigDecimal("0.1"));  // 0.1
        System.out.println(BigDecimal.valueOf(0.1));    // 0.1
        System.out.println(new BigDecimal(0.1));    // 0.1000000000000000055511151231257827021181583404541015625

        BigDecimal vatRate = new BigDecimal("0.1");
        BigDecimal price = new BigDecimal("19900");

        BigDecimal vat = price.multiply(vatRate).setScale(0, RoundingMode.HALF_UP);// 1,990
        System.out.println(vat);

        System.out.println(new BigDecimal("0.10").equals(new BigDecimal("0.1"))); // false
        System.out.println(new BigDecimal("0.10").compareTo(new BigDecimal("0.1")) == 0); // true
    }

    boolean nearlyEqual(double a, double b, double eps) {
        return Math.abs(a - b) < eps;
    }
}
