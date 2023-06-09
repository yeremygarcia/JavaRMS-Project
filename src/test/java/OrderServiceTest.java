import org.example.model.Inventory;
import org.example.utilities.OrderStatus;
import org.example.model.Order;
import org.example.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private OrderService orderService;
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService(inventory);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order(1, 2);
        order.setOrderID(1);
        orderService.addOrder(order);
        Assertions.assertEquals(6, orderService.getTotalOrders());
        Assertions.assertNotEquals(order, orderService.getOrder(3));
    }

    @Test
    public void testRemoveOrder() {
        Order order = new Order(1, 1);
        order.setOrderID(1);
        orderService.addOrder(order);
        orderService.removeOrder(1);
        Assertions.assertNotEquals(0, orderService.getTotalOrders());
        Assertions.assertNull(orderService.getOrder(1));
    }
}

