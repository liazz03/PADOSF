package amazonia.testers;

import static org.junit.Assert.*;

import org.junit.Test;

import amazonia.products.Product;

import amazonia.products.*;

/**
 * Test method for Product
 */
public class ProductTest {

    @Test
    public void testProduct() {
        Product product = new Fragile("The most famous fragile product in the world", 12.50, 4.0, 5.0, 2.0, false);
        Product product2 = new StandardProduct("Soft and easy to use", 2.5, 0.5, 2.15, 0.75);
        assertNotNull(product);
        assertNotNull(product2);
    }
}