package amazonia.testers;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;
import amazonia.application.Amazonia;
import amazonia.products.*;
import amazonia.users.*;

/**	
 * Test method for Driver
 */
public class DriverTest {

	private Driver driver;

	@Before
	public void setUp() {
		driver = new Driver("Manolo", "1234", 917364761);
	}

	/*
	 * Test for getters and setters
	 */
	@Test
	public void testGettersAndSetters() {
		driver.setName("Manolo");
		assertEquals("Manolo", driver.getName());
		driver.setPassword("1234");
		assertEquals("1234", driver.getPassword());
		driver.setPhoneNumber(917364761);
		assertEquals(917364761, driver.getPhoneNumber());
	}

	/*
	 * Test for setDelivered
	 */
	@Test
	public void testSetDelivered() throws FileNotFoundException, IOException {
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		Operator operator = new Operator("Operator_test", "Password");

		Amazonia.getInstance().setOperator(operator);
		Amazonia.getInstance().addCompany(company);
		Amazonia.getInstance().addDrivers(driver);
		Amazonia.getInstance().loadTrucks("files\\fleet.txt");
		
		List<Product> products = new ArrayList<>();
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));

		company.placeOrder(products, false);
		assertFalse(Amazonia.getInstance().getCompanies().get(0).getOrder().getDelivered());
		//driver calls Amazonia.setDelivered --> Amazonia.setDelivered --> Amazonia notifies company
		driver.setDelivered(company.getOrder().getId());
		assertTrue(Amazonia.getInstance().getCompanies().get(0).getOrder().getDelivered());
		
		//Set a given truck as broken
		driver.reportBroken("1393BFK");
		//Truck in system must be broken now
		assertTrue(Amazonia.getInstance().getTrucks().get(1).getBroken());
		
		//Operator sets truck as fixed
		operator.setTruckFixed("1393BFK");
		
		//Truck must be fixed now
		assertFalse(Amazonia.getInstance().getTrucks().get(1).getBroken());
		
	}
	
	
	
	
	
	
	
}