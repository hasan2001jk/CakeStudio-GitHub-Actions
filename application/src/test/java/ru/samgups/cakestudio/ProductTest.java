package ru.samgups.cakestudio;
import org.junit.jupiter.api.Test;
import ru.samgups.cakestudio.entity.Product;
import ru.samgups.cakestudio.entity.Category;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testEmptyConstructor() {
        Product product = new Product();
        assertNull(product.getId());
        assertNull(product.getName());
        assertNull(product.getPrice());
        assertNull(product.getOldPrice());
        assertNull(product.getImage());
        assertNull(product.getDescription());
        assertNull(product.getProductCategory());
    }

  
    @Test
    public void testGetterAndSetters() {
        Product product = new Product();

        // Set new values
        Long id = 2L;
        String name = "Strawberry Cheesecake";
        Double price = 18.50;
        Double oldPrice = 20.99;
        String image = "cheesecake.png";
        String description = "Light and creamy strawberry cheesecake with a graham cracker crust.";
        Category category = new Category(); // Assuming a Category object

        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setOldPrice(oldPrice);
        product.setImage(image);
        product.setDescription(description);
        product.setProductCategory(category);

        // Assert values
        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
        assertEquals(oldPrice, product.getOldPrice());
        assertEquals(image, product.getImage());
        assertEquals(description, product.getDescription());
        assertEquals(category, product.getProductCategory());
    }

    // Additional tests for validation, relationships, etc., as needed
}
