package ru.samgups.cakestudio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.samgups.cakestudio.entity.OrderItem;
import ru.samgups.cakestudio.entity.Order;
import ru.samgups.cakestudio.entity.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderItemTest {

    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        orderItem = new OrderItem();
    }

    @Test
    public void testConstructor() {
        assertNotNull(orderItem);
    }

    @Test
    public void testIdGetterAndSetter() {
        Long id = 1L;
        orderItem.setId(id);
        assertEquals(id, orderItem.getId());
    }

    @Test
    public void testOrderGetterAndSetter() {
        Order order = new Order();
        orderItem.setOrder(order);
        assertEquals(order, orderItem.getOrder());
    }

    @Test
    public void testProductGetterAndSetter() {
        Product product = new Product();
        orderItem.setProduct(product);
        assertEquals(product, orderItem.getProduct());
    }

    @Test
    public void testQuantityGetterAndSetter() {
        int quantity = 5;
        orderItem.setQuantity(quantity);
        assertEquals(quantity, orderItem.getQuantity());
    }

    @Test
    public void testPriceGetterAndSetter() {
        double price = 20.00;
        orderItem.setPrice(price);
        assertEquals(price, orderItem.getPrice());
    }
}
