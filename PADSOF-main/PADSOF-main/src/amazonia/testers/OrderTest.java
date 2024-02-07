package amazonia.testers;

import amazonia.packages.Order;
import amazonia.users.*;
import amazonia.products.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import java.time.LocalDate;

/**	
 * Test method for Order
 */
public class OrderTest {
	
	
	/*
	 * Test for Order
	 */
	@Test
	public void testOrder() {
		
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		Order o = new Order(false,LocalDate.now(),false,false,company);
		
		assertNotNull(o);
		assertEquals(o.getReattempts(), 3);
	}

	/**
	 * Test for DoPackaging
	 */
	@Test
	public void testDoPackaging() {
		
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
		
		Order o = new Order(false,LocalDate.now(),false,false,company);
		o.DoPackaging(products);
		
		assertNotNull(o.getPackages());
	}
	
	/**
	 * Test for CalculateTotalPrice
	 */
	@Test
	public void testCalculateTotalPrice_GenerateInvoice() {
		
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
		
		Order o = new Order(false,LocalDate.now(),false,false,company);
		o.DoPackaging(products);
		o.CalculateTotalPrice();
		//test total price
		assertTrue(o.getPrice()==8.399999999999999);
		//generate invoice
		assertTrue(o.generateInvoice());

	}
	
	/**
	 * Test for payOrder
	 */
	@Test
	public void testpayOrder() {
		
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
		
		Order o = new Order(false,LocalDate.now(),false,false,company);
		o.DoPackaging(products);
		o.CalculateTotalPrice();
		
		assertTrue(o.payOrder());
		
		company.setCardNumber("123456789012355"); // invalid credit card
		assertFalse(o.payOrder());
		
	}
}
