import org.example.Order;
import org.example.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        order.setOrderID(1);
        orderService.addOrder(order);
        Assertions.assertEquals(1, orderService.getTotalOrders());
        Assertions.assertNotEquals(order, orderService.getOrder(1));
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order();
        order.setOrderID(1);
        orderService.addOrder(order);
        orderService.removeOrder(1);
        Assertions.assertNotEquals(0, orderService.getTotalOrders());
        Assertions.assertNull(orderService.getOrder(1));
    }

    @Test
    public void testUpdateStatus() {
        Order order1 = new Order();
        order1.setOrderID(1);
        order1.setOrderStatus(Order.OrderStatus.READY);
        Order order2 = new Order();
        order2.setOrderID(2);
        order2.setOrderStatus(Order.OrderStatus.PREPARING);
        Order order3 = new Order();
        order3.setOrderID(3);
        order3.setOrderStatus(Order.OrderStatus.WAITING);

        orderService.addOrder(order1);
        orderService.addOrder(order2);
        orderService.addOrder(order3);

        String foundOrders = orderService.updateStatus(Order.OrderStatus.WAITING);
        Assertions.assertFalse(foundOrders.contains(order1.toString()));
        Assertions.assertTrue(foundOrders.contains(order3.toString()));
        Assertions.assertFalse(foundOrders.contains(order2.toString()));
    }
}

