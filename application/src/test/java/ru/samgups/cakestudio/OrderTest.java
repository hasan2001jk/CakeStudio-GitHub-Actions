package ru.samgups.cakestudio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.samgups.cakestudio.entity.Order;
import ru.samgups.cakestudio.entity.OrderItem;
import ru.samgups.cakestudio.entity.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderTest {

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testConstructor() {
        assertNotNull(order);
    }

    @Test
    public void testIdGetterAndSetter() {
        Long id = 1L;
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    public void testUserGetterAndSetter() {
        User user = new User();
        order.setUser(user);
        assertEquals(user, order.getUser());
    }

    @Test
    public void testOrderItemsGetterAndSetter() {
        List<OrderItem> orderItems = new ArrayList<>();
        order.setOrderItems(orderItems);
        assertEquals(orderItems, order.getOrderItems());
    }

    @Test
    public void testOrderDateGetterAndSetter() {
        LocalDateTime orderDate = LocalDateTime.now();
        order.setOrderDate(orderDate);
        assertEquals(orderDate, order.getOrderDate());
    }

    @Test
    public void testShippingAddressGetterAndSetter() {
        String shippingAddress = "123 Main St, City, Country";
        order.setShippingAddress(shippingAddress);
        assertEquals(shippingAddress, order.getShippingAddress());
    }

    @Test
    public void testStatusGetterAndSetter() {
        String status = "Processing";
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }

    @Test
    public void testPaymentMethodGetterAndSetter() {
        String paymentMethod = "Credit Card";
        order.setPaymentMethod(paymentMethod);
        assertEquals(paymentMethod, order.getPaymentMethod());
    }

    @Test
    public void testTotalPriceGetterAndSetter() {
        double totalPrice = 100.00;
        order.setTotalPrice(totalPrice);
        assertEquals(totalPrice, order.getTotalPrice());
    }
}
