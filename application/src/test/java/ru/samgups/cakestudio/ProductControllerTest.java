import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import ru.samgups.cakestudio.controller.ProductController;
import ru.samgups.cakestudio.entity.Product;
import ru.samgups.cakestudio.entity.CartItem;
import ru.samgups.cakestudio.repository.ProductRepository;
import ru.samgups.cakestudio.service.ShoppingCartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ShoppingCartService shoppingCartService;

    @InjectMocks
    private ProductController productController;

    @Mock
    private HttpServletRequest mockRequest;

    @Test
    public void testViewCart_withCartItemsInCookie() {
        // Mock cookie with cart items
        List<Long> productIds = Arrays.asList(1L, 2L);
        String cartCookieValue = createCartCookieValue(productIds);
        Cookie cartCookie = new Cookie("cart", cartCookieValue);
        when(mockRequest.getCookies()).thenReturn(new Cookie[]{cartCookie});
        Mockito.lenient().when(mockRequest.getHeader("Referer")).thenReturn("http://example.com");


        // Mock product repository to return products for the cart items
        List<Product> products = Arrays.asList(
                new Product(), // Assuming Product doesn't require parameters for instantiation
                new Product());
        when(productRepository.findAllById(productIds)).thenReturn(products);

        // Call the controller method
        Model model = Mockito.mock(Model.class);
        String viewName = productController.viewCart(mockRequest, model);

        // Assertions
        // assertEquals("redirect:http://example.com", viewName); // Assert redirection
        // assertThat(model.getAttribute("cart_item")).isNotNull();
        // assertThat((Double) model.getAttribute("total_price")).isEqualTo(0.0, offset(0.01));
    }

    @Test
    public void testViewCart_withEmptyCookie() {
        // Mock empty cookie
        when(mockRequest.getCookies()).thenReturn(new Cookie[]{});
        Mockito.lenient().when(mockRequest.getHeader("Referer")).thenReturn("http://example.com");

        // Call the controller method
        Model model = Mockito.mock(Model.class);
        String viewName = productController.viewCart(mockRequest, model);

        // Assertions
        // assertEquals("redirect:http://example.com", viewName); // Assert redirection
        // assertThat(model.getAttribute("cart_item")).isNull();
        // assertThat((Double) model.getAttribute("total_price")).isEqualTo(0.0, offset(0.01));
    }

    private String createCartCookieValue(List<Long> productIds) {
        StringBuilder sb = new StringBuilder();
        for (Long productId : productIds) {
            sb.append(productId).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
