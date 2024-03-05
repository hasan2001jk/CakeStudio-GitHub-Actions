import static org.junit.jupiter.api.Assertions.assertEquals;
import ru.samgups.cakestudio.entity.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {

    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("123 Main St", "Apt 101", "Springfield", "IL", "12345");
    }

    @Test
    public void testGetAddressLine1() {
        assertEquals("123 Main St", address.getAddressLine1());
    }

    @Test
    public void testGetAddressLine2() {
        assertEquals("Apt 101", address.getAddressLine2());
    }

    @Test
    public void testGetCity() {
        assertEquals("Springfield", address.getCity());
    }

    @Test
    public void testGetState() {
        assertEquals("IL", address.getState());
    }

    @Test
    public void testGetPostalCode() {
        assertEquals("12345", address.getPostalCode());
    }

    @Test
    public void testSetAddressLine1() {
        address.setAddressLine1("456 Elm St");
        assertEquals("456 Elm St", address.getAddressLine1());
    }

    @Test
    public void testSetAddressLine2() {
        address.setAddressLine2("Apt 202");
        assertEquals("Apt 202", address.getAddressLine2());
    }

    @Test
    public void testSetCity() {
        address.setCity("Riverside");
        assertEquals("Riverside", address.getCity());
    }

    @Test
    public void testSetState() {
        address.setState("CA");
        assertEquals("CA", address.getState());
    }

    @Test
    public void testSetPostalCode() {
        address.setPostalCode("54321");
        assertEquals("54321", address.getPostalCode());
    }
}
