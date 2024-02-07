/**
 * 
 */
package amazonia.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import amazonia.products.*;
import amazonia.packages.*;
import amazonia.application.Amazonia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import amazonia.users.Company;
import amazonia.users.Operator;

/**	
 * Test method for Operator
 */
public class OperatorTest {

	private Operator operator;

	@Before
	public void setUp() {
		operator = new Operator("Operator_test", "Password");
	}

	/*
	 * Test for Operator
	 */
	@Test
	public void testOperator() {
		assertNotNull(operator);
	}
	
	/*
	 * Test for createOrder
	 */
	@Test
	public void testcreateOrder() {
		
		Operator operator = new Operator("Operator_test", "Password");
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		Amazonia.getInstance().addCompany(company);
		Amazonia.getInstance().setOperator(operator);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
		
		Order o = operator.createOrder(products, false, company, LocalDate.now());
		assertNotNull(o);
		
	}

	/*
	 * Test forcreateDeliveryPlan
	 */
	@Test
	public void testcreateDeliveryPlan() throws FileNotFoundException, IOException{

		Operator operator = new Operator("Operator_test", "Password");
		Company company2 = new Company("COMPANY TEST2", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);
		Company company = new Company("COMPANY TEST", "ABC", "1234567890123456", 1223, "COMPANYTEST@gmail.com", "Calle ABC 102", 28033);

		Amazonia.getInstance().addCompany(company2);
		Amazonia.getInstance().addCompany(company);
		Amazonia.getInstance().setOperator(operator);
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
		company2.placeOrder(products, true);

		//call amazonia --> amazonia calls operator.createDeliveryPlan
		Amazonia.getInstance().setDeliveryPlan();

		assertNotNull(Amazonia.getInstance().getDeliveryPlan());

	}
}
