import org.example.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    @DisplayName("getName() should return the customer's name")
    public void testGetName() {
        Customer customer = new Customer("staff1");
        assertEquals("staff1", customer.getName());
    }

    @Test
    @DisplayName("setName() should update the customer's name")
    public void testSetName() {
        Customer customer = new Customer("staff2");
        customer.setName("staff3");
        assertEquals("staff3", customer.getName());
    }
}
