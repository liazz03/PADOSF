package amazonia.testers;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import amazonia.packages.*;
import amazonia.users.Driver;


/**	
 * Test method for DeliveryPlan
 */
public class DeliveryPlanTest {

	private DeliveryPlan deliveryPlan;
	private List<String> routes = new ArrayList<>();
	private Driver driver = new Driver("Pocholo", "pochololo", 917364761);

	@Before
	public void setUp() {
		deliveryPlan = new DeliveryPlan();
		routes.add("Hortaleza");
		routes.add("Manoteras");
	}

	/**
	 * Test method for DeliveryPlan
	 */
	@Test
	public void testDeliveryPlan() {
		deliveryPlan.addRoute("Hortaleza");
		deliveryPlan.addRoute("Manoteras");
		assertNotNull(deliveryPlan);
	}

	/**
	 * Test method for getters and setters
	 */
	@Test
	public void testGettersAndSetters() {
		deliveryPlan.setRoute(routes);
		deliveryPlan.setDriver(driver);
		assertEquals("Hortaleza", deliveryPlan.getRoute().get(0));
		assertEquals("Manoteras", deliveryPlan.getRoute().get(1));
		assertEquals(driver, deliveryPlan.getDriver());
	}
}
