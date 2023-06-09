import org.example.utilities.OrderStatus;
import org.example.model.Order;
import org.example.services.OrderService;
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
        Order order = new Order(1);
        order.setOrderID(1);
        orderService.addOrder(order);
        Assertions.assertEquals(1, orderService.getTotalOrders());
        Assertions.assertNotEquals(order, orderService.getOrder(1));
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order(1);
        order.setOrderID(1);
        orderService.addOrder(order);
        orderService.removeOrder(1);
        Assertions.assertNotEquals(0, orderService.getTotalOrders());
        Assertions.assertNull(orderService.getOrder(1));
    }

    @Test
    public void testUpdateStatus() {
        Order order1 = new Order(1);
        order1.setOrderID(1);
        order1.setOrderStatus(OrderStatus.READY);
        Order order2 = new Order(2);
        order2.setOrderID(2);
        order2.setOrderStatus(OrderStatus.PREPARING);
        Order order3 = new Order(3);
        order3.setOrderID(3);
        order3.setOrderStatus(OrderStatus.WAITING);

        orderService.addOrder(order1);
        orderService.addOrder(order2);
        orderService.addOrder(order3);

//        String foundOrders = orderService.updateStatus(OrderStatus.WAITING);
//        Assertions.assertFalse(foundOrders.contains(order1.toString()));
//        Assertions.assertTrue(foundOrders.contains(order3.toString()));
//        Assertions.assertFalse(foundOrders.contains(order2.toString()));
    }
}

