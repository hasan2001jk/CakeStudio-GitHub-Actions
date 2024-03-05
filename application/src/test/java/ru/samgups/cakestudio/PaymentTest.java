package ru.samgups.cakestudio;
import ru.samgups.cakestudio.entity.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testDefaultConstructor() {
        Payment payment = new Payment();
        assertNotNull(payment);
    }

    @Test
    public void testParameterizedConstructor() {
        String paymentMethod = "Credit Card";
        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String securityCode = "123";

        Payment payment = new Payment(paymentMethod, cardNumber, expirationDate, securityCode);

        assertEquals(paymentMethod, payment.getPaymentMethod());
        assertEquals(cardNumber, payment.getCardNumber());
        assertEquals(expirationDate, payment.getExpirationDate());
        assertEquals(securityCode, payment.getSecurityCode());
    }

    @Test
    public void testGettersAndSetters() {
        Payment payment = new Payment();

        String paymentMethod = "Credit Card";
        String cardNumber = "1234567890123456";
        String expirationDate = "12/25";
        String securityCode = "123";

        payment.setPaymentMethod(paymentMethod);
        payment.setCardNumber(cardNumber);
        payment.setExpirationDate(expirationDate);
        payment.setSecurityCode(securityCode);

        assertEquals(paymentMethod, payment.getPaymentMethod());
        assertEquals(cardNumber, payment.getCardNumber());
        assertEquals(expirationDate, payment.getExpirationDate());
        assertEquals(securityCode, payment.getSecurityCode());
    }
}
