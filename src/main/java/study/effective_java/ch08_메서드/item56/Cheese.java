package study.effective_java.ch08_메서드.item56;

import java.util.Objects;

/**
 * 치즈를 표현하는 값 객체(Value Object)
 * <p>
 * 불변 클래스이며 이름(name)만으로 동일성을 판단한다.
 */
public class Cheese {
    private final String name;

    /**
     * 주어진 이름으로 치즈를 생성한다.
     *
     * @param name 치즈 이름 (null 불가)
     * @throws NullPointerException name이 null인 경우
     */
    public Cheese(String name) {
        this.name = Objects.requireNonNull(name, "name");
    }

    /**
     * 치즈의 이름을 반환한다.
     *
     * @return 치즈 이름 (절대 null 아님)
     */
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return "Cheese{" + name + "}";
    }
}
