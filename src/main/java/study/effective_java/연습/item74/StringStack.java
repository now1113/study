package study.effective_java.연습.item74;

import java.util.NoSuchElementException;

public class StringStack {

    // 나쁜 예: 비검사 예외를 throws에 올려놓음
    public String pop() throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    /**
     * 스택의 맨 위 원소를 제거하고 반환한다.
     *
     * @return 제거된 왼소
     * @throws NoSuchElementException if this stack is empty
     */
    public String popV2() {
        throw new NoSuchElementException();
    }
}
