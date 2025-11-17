package study.effective_java.연습.item72;

import java.util.*;

public class Order {
    private final String orderId;
    private Status status;
    private final List<OrderLine> lines = new ArrayList<>();
    private String memo;
    private boolean deleted;

    private int version = 0;

    // NullPointerException, IllegalArgumentException
    public Order(String orderId) {
        this.orderId = Objects.requireNonNull(orderId, "orderId must not be null");

        if (orderId.isEmpty()) {
            throw new IllegalArgumentException("orderId must not be empty");
        }
        this.status = Status.CREATED;
    }

    // 잘못된 인자 (IllegalArgumentException)
    // 이미 취소/배송된 주문은 상태 변경 불가라고 가정
    public void changeStatus(Status newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("newStatus must not be null");
        }

        if (isCanceled() || isShipped()) {
            throw new IllegalStateException(
                    "cannot change status from " + this.status + " to " + newStatus
            );
        }

        this.status = newStatus;
        version++;
    }

    // 인자가 Null이면 안될 때, memo는 빈 문자열은 허용
    public void setMemo(String memo) {
        this.memo = Objects.requireNonNull(memo, "memo must not be null");
        version++;
    }

    public boolean isCanceled() {
        return this.status == Status.CANCELED;
    }

    public boolean isShipped() {
        return this.status == Status.SHIPPED;
    }

    public void addLine(OrderLine orderLine) {
        if (deleted) {
            throw new IllegalStateException("deleted order cannot add lines");
        }
        this.lines.add(Objects.requireNonNull(orderLine, "orderLine must not be null"));
        version++;
    }

    public OrderLine getLine(int index) {
        if (index < 0 || index >= this.lines.size()) {
            throw new IndexOutOfBoundsException(
                    "index: " + index + ", size: " + lines.size()
            );
        }
        return lines.get(index);
    }

    // 읽기 전용 뷰 제공 (외부에서 수정 시 UnsupportedOperationException 발생 가능)
    public List<OrderLine> getLinesView() {
        return Collections.unmodifiableList(lines);
    }

    // 지원하지 않는 연산 (UnsupportedOperationException)
    // 전체 삭제 기능은 지원하지 않는다고 가정
    public void clearLines() {
        throw new UnsupportedOperationException("clearLines not supported");
    }

    // 동시 수정 감시 (ConcurrentModificationException)
    public void assertNotModifiedSince(int expectedVersion) {
        if (this.version != expectedVersion) {
            throw new ConcurrentModificationException(
                    "Order modified concurrently: expectedVersion=" + expectedVersion +
                            ", currentVersion=" + version
            );
        }
    }

    // 형변환 에러 (classCastException)
    public OrderLine asOrderLine(Object value) {
        if (!(value instanceof OrderLine)) {
            throw new ClassCastException(
                    "Expected OrderLine but was " +
                            (value == null ? "null" : value.getClass().getName())
            );
        }
        return (OrderLine) value;
    }
}
