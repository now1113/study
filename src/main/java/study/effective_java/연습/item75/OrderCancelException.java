package study.effective_java.연습.item75;

public class OrderCancelException extends Exception {

    private final String orderNo;
    private final String currentStatus;
    private final String requestedStatus;
    private final String requestedBy;

    public OrderCancelException(
            String orderNo,
            String currentStatus,
            String requestedStatus,
            String requestedBy) {
        super(buildMessage(orderNo, currentStatus, requestedStatus, requestedBy));
        this.orderNo = orderNo;
        this.currentStatus = currentStatus;
        this.requestedStatus = requestedStatus;
        this.requestedBy = requestedBy;
    }

    private static String buildMessage(
            String orderNo,
            String currentStatus,
            String requestedStatus,
            String requestedBy) {
        //
        return "Order cannot be canceled. " +
                "orderNo=" + orderNo +
                ", currentStatus=" + currentStatus +
                ", requestedStatus=" + requestedStatus +
                ", requestedBy=" + requestedBy;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public String getRequestedStatus() {
        return requestedStatus;
    }

    public String getRequestedBy() {
        return requestedBy;
    }
}
