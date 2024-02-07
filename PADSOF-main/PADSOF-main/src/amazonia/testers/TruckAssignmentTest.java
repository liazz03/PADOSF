package amazonia.testers;

import static org.junit.Assert.*;

import amazonia.packages.Package;
import amazonia.products.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import amazonia.trucks.*;

/**	
 * Test method for TruckAssignment
 */
public class TruckAssignmentTest {

	private TruckAssignment ta;
	private Truck t;
	private List<Product> products = new ArrayList<>();
	private List<Package> packs = new ArrayList<>();
	Package pack1 = new Package(0, false, false, false); 

	@Before
	public void setUp() {
		t = new Truck(3500.0, "2322BBC", false, false, TruckType.REFRIGERATED);
		ta = new TruckAssignment(t);

		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));

		Package pack1 = new Package( 0, false, false, false);
		Package pack2 = new Package( 0, false, false, false);
		Package pack3 = new Package( 0, false, false, false);

		pack1.addProduct(products.get(0));
		pack1.addProduct(products.get(1));

		pack2.addProduct(products.get(2));
		pack2.addProduct(products.get(3));

		pack3.addProduct(products.get(4));
		pack3.addProduct(products.get(5));
		
		packs.add(pack1);
		packs.add(pack2);
		packs.add(pack3);
		
		ta.addPackage(pack1);
		ta.addPackage(pack2);
		ta.addPackage(pack3);
	}

	/*
	 * Test for getters and setters
	 */
	@Test
	public void testGettersAndSetters() {
		assertEquals(t, ta.getTruck());
		assertEquals(packs, ta.getPackages());
	}
}
