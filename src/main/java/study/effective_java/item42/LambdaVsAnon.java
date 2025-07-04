package study.effective_java.item42;

public class LambdaVsAnon {

    String instanceName = "Outer";

    void run() {
        Runnable anon = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.instanceName); // 오류, this는 익명 클래스 자신
            }
        };

        Runnable lambda = () -> {
            System.out.println(this.instanceName); // 람다의 this는 바깥 클래스
        };
    }
}
