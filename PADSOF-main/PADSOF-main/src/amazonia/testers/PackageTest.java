/**
 * 
 */
package amazonia.testers;
import amazonia.packages.Package;
import amazonia.products.Frozen;
import amazonia.products.Product;
import amazonia.products.RefrigeratedFood;
import amazonia.products.StandardFood;
import amazonia.products.StandardProduct;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**	
 * Test method for Package
 */
public class PackageTest {

	/**
	 * Test method for Package
	 */
	@Test
	public void testPackage() {
		
		Package pack = new Package(0,false,false,false);
		assertNotNull(pack);
	}
	
	/**
	 * Test method for addProduct
	 */
	@Test
	public void testaddProduct() {
		
		Package pack = new Package(0,false,false,false);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 46,3,1,2));
		products.add(new StandardFood("StandardFood_3", 49,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
		
		pack.addProduct(products.get(0));
		pack.addProduct(products.get(6));
		
		assertTrue(pack.getPrice()==4.00000000000000);
		assertTrue(pack.getWeight()==4.00000000000000);
		
		//add product to full package
		assertFalse(pack.addProduct(products.get(5)));
		
		//add product to package so now its full
		pack.addProduct(products.get(4));
		assertTrue(pack.getFull());
	}
	
	/**
	 * Test method for containsType
	 */
	@Test
	public void testContainsType() {
		
		Package pack = new Package(0,false,false,false);
		List<Product> products = new ArrayList<>();
		
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 3,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));

		pack.addProduct(products.get(0));
		pack.addProduct(products.get(2));
		pack.addProduct(products.get(3));
		pack.addProduct(products.get(4));
		pack.addProduct(products.get(5));

		assertTrue(pack.containsTYPE(2));
		assertFalse(pack.containsTYPE(3));
		assertTrue(pack.containsTYPE(4));
		assertTrue(pack.containsTYPE(0));

	}
}
