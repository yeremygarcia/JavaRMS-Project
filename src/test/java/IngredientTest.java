//import org.example.Ingredient;
import org.example.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
    @Test
    @DisplayName("toString() should return the correct string representation")
    public void testToString() {
        Ingredient ingredient = new Ingredient("bun", 20, 15);
        String expected = "Ingredient: bun, Quantity: 20";
        assertNotEquals(20, ingredient.toString());
    }
    @Test
    @DisplayName("getters should return the correct values")
    public void testGetters() {
        Ingredient ingredient = new Ingredient("lettuce", 100, 65);
        assertEquals("lettuce", ingredient.getName());
        assertEquals(100, ingredient.getQuantity());
        assertEquals(65, ingredient.getThreshold());
    }
    @Test
    @DisplayName("setQuantity() should update the quantity")
    public void testSetQuantity() {
        Ingredient ingredient = new Ingredient("pickle", 100, 75);
        ingredient.setQuantity(100);
        assertEquals(100, ingredient.getQuantity());
    }
}
