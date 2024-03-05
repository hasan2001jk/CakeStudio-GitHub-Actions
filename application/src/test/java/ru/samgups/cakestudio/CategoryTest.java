package ru.samgups.cakestudio;
import org.junit.jupiter.api.Test;
import ru.samgups.cakestudio.entity.Category;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryTest {

    @Test
    public void testConstructor_noArgs() {
        Category category = new Category();
        assertNotNull(category);
    }

    @Test
    public void testSetNameAndGetters() {
        String expectedName = "Test Category";
        Category category = new Category();
        category.setName(expectedName);
        assertEquals(expectedName, category.getName());
    }

    @Test
    public void testSetName_emptyString() {
        Category category = new Category();
        assertThrows(IllegalArgumentException.class, () -> category.setName(""));
    }
    
    @Test
    public void testSetName_null() {
        Category category = new Category();
        assertThrows(IllegalArgumentException.class, () -> category.setName(null));
    }


}
