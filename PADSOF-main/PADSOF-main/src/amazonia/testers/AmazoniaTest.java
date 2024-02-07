package amazonia.testers;
import amazonia.trucks.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import amazonia.application.Amazonia;
import amazonia.packages.Order;
import amazonia.packages.OrderStatus;
import amazonia.users.*;

/**	
 * Test method for Amazonia
 */
public class AmazoniaTest {
	private Operator operator;
	private Company company;
	private Company company1;

	@Before 
	public void setUp() {
		operator = new Operator("Operator_test", "Password");
		company = new Company("Mercedes", "mercedes123", "1234567890123456", 28559593, "mercedes@gmail.com", "Brackley", 9701);
		company1 = new Company("COMPANY TEST2", "company test", "1234567890123456", 28559593, "companytest@gmail.com", "C o m p a n y", 9701);
	}
	

	/**
	 * Test method for loadTrucks
	 */
	@Test
	public void testLoadTrucks() throws FileNotFoundException, IOException {
		Amazonia.getInstance().loadTrucks("files\\fleet.txt");
		
		assertEquals(9, Amazonia.getInstance().getTrucks().size());
		
		assertEquals("2322BBC", Amazonia.getInstance().getTrucks().get(0).getLicensePlate());
		assertEquals("1393BFK", Amazonia.getInstance().getTrucks().get(1).getLicensePlate());
		assertTrue(1000.000000000000000 == Amazonia.getInstance().getTrucks().get(8).getMaxWeight());
		assertEquals(TruckType.REFRIGERATED,Amazonia.getInstance().getTrucks().get(3).getType());
	}
	
	/**
	 * Test method for login
	 */
	@Test
	public void testLogin() {
		//It is assumed AmazoniaTest.java is executed all at once, so companies are added once to to the instance
		Amazonia.getInstance().setOperator(operator);
		//Add company should be only used for testing and inside RegisterCompany()
		Amazonia.getInstance().addCompany(company);
		Amazonia.getInstance().addCompany(company1);
		
		assertTrue(company.login(company.getName(), company.getPassword()));
		//company non existent
		assertFalse(company.login("COMPANY NON EXISTING", "FALSECOMPANY"));
 	}

	/**
	 * Test method for logout
	 */
	@Test
	public void testLogout() {
		assertTrue(company.logout());
	}
	
	/**
	 * Test method for registerCompany
	 */
	@Test
	public void testRegisterCompany() {
		try {
			Amazonia.getInstance().registerCompany("COMPANY TEST 3","PASSWORD TEST 3", "1234567890123456", 0316,"companytest@gmail.com", "Calle TEst 02", 5293);
		}catch (IOException expection) {
            System.out.println("error");
        }
		assertEquals(3,Amazonia.getInstance().getCompanies().size());
		
		//register company with incorrect zip
		try {
			Amazonia.getInstance().registerCompany("COMPANY TEST 3","PASSWORD TEST 3", "1234567890123456", 0316,"companytest@gmail.com", "Calle TEst 02",1234);
		}catch (IOException expection) {
            System.out.println("error");
        }
		assertEquals(3,Amazonia.getInstance().getCompanies().size());
	}

	/**
	 * Test method for registerDriver
	 */
	@Test
	public void testRegisterDriver() {
		Amazonia.getInstance().registerDriver("Manolo", "passwordtestdriver", 677354678);
		assertEquals(1,Amazonia.getInstance().getDrivers().size());
		assertEquals(5,Amazonia.getInstance().getUsers().size());
		
		//register new driver with existent password
		assertFalse(Amazonia.getInstance().registerDriver("Manolo", "passwordtestdriver", 677354078));
		
	}
	
	/**
	 * Test method for notifyCompany
	 */
	@Test
	public void notifyCompany() {
		//notify mercedes	
		Order o = new Order(false, LocalDate.now(), false, true, company);
		Amazonia.getInstance().notifyCompany("Mercedes", OrderStatus.INDELIVERY,o);
		
		assertEquals("Your Order with id: 0 is: INDELIVERY",Amazonia.getInstance().getCompanies().get(Amazonia.getInstance().getCompanyInd("Mercedes")).getNotifications().get(0).getText());
	}

	@Ignore
	@Test
	public void saveAndLoadTest() throws IOException{
		Order o = new Order(false, LocalDate.now(), false, true, company);
		Truck truck = new Truck(3500.0, "2322BBC", false, false, TruckType.REFRIGERATED); 
		Amazonia.getInstance().addOrder(o);
		Amazonia.getInstance().addTruck(truck);

		Amazonia.getInstance().save("./files/Amazonia_log.txt");

		//assertEquals(Amazonia.getInstance(), Amazonia.getInstance().load("./files/Amazonia_log.txt"));

	}
}
