package amazonia.testers;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import amazonia.application.Amazonia;

import org.junit.Before;
import org.junit.Test;
import amazonia.products.*;
import amazonia.users.*;


/**	
 * Test method for Company
 */
public class CompanyTest {

	private Operator operator;
	private Company company;

	@Before
	public void setUp() {
		operator = new Operator("Operator_test", "Password");
		company = new Company("Mercedes", "mercedes123", "1234567890123456", 28559593, "mercedes@gmail.com", "Brackley", 9701);
	}

	/**
	 * Test method for Company
	 */
	@Test
	public void testCompany() {
		assertNotNull(company);
	}

	/**
	 * Test method for checkZIP
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testCheckZIP() throws FileNotFoundException, IOException {
		assertTrue(company.checkZIP("files\\zips.txt", 8765));
		assertFalse(company.checkZIP("files\\zips.txt", 9999));
	}

	/**
	 * Test method for placeOrder
	 */
	@Test
	public void testPlaceOrder() throws IOException, ClassNotFoundException{
		List<Product> products = new ArrayList<>();
		Amazonia.getInstance().setOperator(operator);
		//company registers
		company.register("Mercedes", "mercedes123", "1234567890123456", 28559593, "mercedes@gmail.com", "Brackley", 9701);

		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		
		//correct order placement
		assertTrue(company.placeOrder(products,false));

		//product with overweight
		products.add(new Frozen("Frozen", 60,3,1,2));
		assertFalse(company.placeOrder(products, false));

		//Amazonia.getInstance(). = null;

	}
}
