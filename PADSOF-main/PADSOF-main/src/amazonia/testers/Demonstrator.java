package amazonia.testers;

import java.io.IOException;
import java.util.*;

import amazonia.application.Amazonia;
import amazonia.products.*;
import amazonia.users.*;

/**	
 * Test method for Demonstrator
 */
public class Demonstrator {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //create operator and two companies and a set of products
        Operator operator = new Operator("Operator_Demo", "pass");
        Company company1 = new Company("Company_Demo1", "password1", "1234567890123456", 28559593, "mercedes@gmail.com", "Brackley", 9701);
		Company company2 = new Company("Company_Demo2", "password2", "1234567890123456", 28559593, "alpine@gmail.com", "Avignon", 8765);
        
        List<Product> products = new ArrayList<>();
		products.add(new Frozen("Frozen_1", 2,3,1,2));
		products.add(new RefrigeratedFood("Refrigerated_1", 4,2,2,2));
		products.add(new StandardProduct("Standard_1", 2,3,1,2));
		products.add(new StandardProduct("Standard_2", 2,3,1,2));
		products.add(new StandardFood("StandardFood_1", 2,3,1,2));
		products.add(new StandardFood("StandardFood_3", 2,3,1,2));
		products.add(new Frozen("Frozen", 2,3,1,2));
      

        //Register two companies and Operator registers one driver
        company1.register(company1.getName(), company1.getPassword(), company1.getCardNumber(), company1.getCIF(), company1.getEmail(), company1.getAddress(), company1.getPostalCode());
        company2.register(company2.getName(), company2.getPassword(), company2.getCardNumber(), company2.getCIF(), company2.getEmail(), company2.getAddress(), company2.getPostalCode());
        operator.registerDriver("Driver_Demo", "password3", 677234512);

        //Companies Place one order each
        company1.placeOrder(products, true);
        company2.placeOrder(products, false);

        //Delivery Plan is created by system 
        Amazonia.getInstance().setDeliveryPlan();

        //Driver Assignment is made by the operator
        operator.addDriverAssignment("Driver_Demo", "1393BFK");
        
        //Order of company 1 is delivered and invoice is automatically generated
        Amazonia.getInstance().setDelivered(company1.getOrder().getId()); 
        
        
        Amazonia.getInstance().save("./files/application.txt");
        

        Amazonia.getInstance().printAllUsers();
        Amazonia.getInstance().printAllTrucks();
        Amazonia.getInstance().printAllOrders();
        Amazonia.getInstance().printDeliveryPlan();
        Amazonia.getInstance().printDriverAssignments();
    }
}