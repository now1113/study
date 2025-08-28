package study.effective_java.ch08_메서드.item56;

import java.util.*;

/**
 * 냉장고를 표현하는 클래스.
 * <p>
 * 여러 개의 {@link Cheese}를 저장하고 검색할 수 있다.
 */
public class Refrigerator {
    private final List<Cheese> cheeses;

    /**
     * 새로운 냉장고를 생성한다.
     *
     * @param cheeses 초기 치즈 목록 (null 허용되지 않음) 비어 있어도 된다.
     */
    public Refrigerator(List<Cheese> cheeses) {
        this.cheeses = new ArrayList<>(Objects.requireNonNull(cheeses));
    }

    /**
     * 주어진 이름을 가진 치즈를 반환한다.
     *
     * @param name 찾을 치즈의 이름, null 불가
     * @return 주어진 이름을 가진 치즈, 없으면 빈 Optional
     * @throws IllegalArgumentException name이 빈 문자열이면 발생
     */
    public Optional<Cheese> findCheese(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }

        return cheeses.stream()
                .filter(c -> c.name().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * 냉장고에 들어있는 모든 치즈를 반환한다.
     *
     * @return 치즈 목록, 수정할 수 없는 리스트. (비어있을 수 있음)
     */
    public List<Cheese> getAllCheeses() {
        return Collections.unmodifiableList(cheeses);
    }
}
