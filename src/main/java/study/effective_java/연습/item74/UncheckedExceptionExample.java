package study.effective_java.연습.item74;

public class UncheckedExceptionExample<E> {

    /**
     * 스택의 맨 위 원소를 제거하고 반환한다.
     *
     * @return 제거된 원소
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E pop() {
        return null;
    }

    /**
     * 지정한 index 위치의 요소를 반환한다.
     *
     * @param index 0 이상, size 미만
     * @return index 위치의 요소
     * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size)
     */
    public E get(int index) {
        // 내부에서 NPE 등이 발생할 수 있지만, 그건 구현 세부사항이고
        // index 범위를 벗어나면 IndexOutOfBoundsException 이라는 계약이 핵심이다.
        return null;
    }
}
