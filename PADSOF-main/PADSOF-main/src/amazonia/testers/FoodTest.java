package amazonia.testers;

import static org.junit.Assert.*;

import org.junit.Test;

import amazonia.products.*;

/**
 * Test method for Food
 */
public class FoodTest {


    @Test
    public void testFood() {
        Food food = new RefrigeratedFood("Ground meat and pork", 0.5, 0.25, 0.25, 0.1);
        Food food2 = new Frozen("Pizza from Casa Tarradellas", 0.25, 0.15, 0.5, 0.1);
        Food food3 = new StandardFood("Raw vegetables", 0.5, 0.2, 0.25, 0.30);

        assertNotNull(food);
        assertNotNull(food2);
        assertNotNull(food3);
    }
}