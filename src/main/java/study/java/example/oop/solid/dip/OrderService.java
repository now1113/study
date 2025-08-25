package study.java.example.oop.solid.dip;

public class OrderService {
    private final MySqlOrderRepository repo = new MySqlOrderRepository();
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
