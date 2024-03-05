package ru.samgups.cakestudio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.samgups.cakestudio.entity.enums.Stuffing;
import ru.samgups.cakestudio.entity.CartItem;
import ru.samgups.cakestudio.entity.Product;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class CartItemTest {

    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        // Create a mock Product object
        Product mockProduct = mock(Product.class);

        // Create a CartItem object with mock Product
        cartItem = new CartItem(mockProduct, 2, Stuffing.STUFFING_OREO_PREMIUM); // Example stuffing used for testing
    }

    @Test
    void testCartItemConstructor() {
        assertNotNull(cartItem);
        assertEquals(2, cartItem.getQuantity());
        assertNotNull(cartItem.getCreatedAt());
    }

    @Test
    void testGettersAndSetters() {
        // Test product getter and setter
        Product newProduct = mock(Product.class);
        cartItem.setProduct(newProduct);
        assertEquals(newProduct, cartItem.getProduct());

        // Test quantity getter and setter
        cartItem.setQuantity(5);
        assertEquals(5, cartItem.getQuantity());

        // Test stuffing getter and setter
        cartItem.setStuffing(Stuffing.STUFFING_TRUFFLE_PREMIUM); // Example stuffing used for testing
        assertEquals(Stuffing.STUFFING_TRUFFLE_PREMIUM, cartItem.getStuffing());

        // Test createdAt getter and setter
        LocalDateTime newDateTime = LocalDateTime.now();
        cartItem.setCreatedAt(newDateTime);
        assertEquals(newDateTime, cartItem.getCreatedAt());
    }

    @Test
    void testToString() {
        // Ensure toString method returns expected format
        String expectedToString = "CartItem{cartItem.id=nullproduct=null, quantity=2}";
        assertEquals(expectedToString, cartItem.toString());
    }
}
