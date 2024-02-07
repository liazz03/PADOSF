package amazonia.testers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import amazonia.trucks.*;

/**	
 * Test method for Truck
 */
public class TruckTest {

	private Truck truck;

	@Before
	public void setUp() {
		truck = new Truck(3500.0, "2322BBC", false, false, TruckType.REFRIGERATED);
	}

	/*
	 * Test for getters and setters
	 */
	@Test
	public void testGettersAndSetters() {

		assertTrue(3500.0 == truck.getMaxWeight());
		assertEquals("2322BBC", truck.getLicensePlate());
		assertEquals(false, truck.getBroken());
		assertEquals(false, truck.isFull());
	}
}
