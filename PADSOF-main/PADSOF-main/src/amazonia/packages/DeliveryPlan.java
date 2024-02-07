package amazonia.packages;

import java.io.Serializable;
import java.util.*;
import amazonia.users.*;
import amazonia.trucks.*;

/**
 * This class prints information about the delivery plan
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class DeliveryPlan implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> route = new ArrayList<>();
    private Driver driver;
    private List<TruckAssignment> tAssignment = new ArrayList<>();
    
    /**
	 * Constructor that creates a new Notification
	 * @param route list of routes
	 * @param driver driver associated to a delivery plan
     * @param tAssignments list of truck assignments
	 */
    public DeliveryPlan(List<String> route, Driver driver, List<TruckAssignment> tAssignments) {
        this.route = route;
        this.driver = driver;
        this.tAssignment = tAssignments;
    }

    /**
     * Default construct to create a delivery plan
     */
    public DeliveryPlan() {
    }

    /**
	 * This getter allows us to get the route of a delivery plan
	 * @return route of a plan
	 */
    public List<String> getRoute(){
        return route;
    }

    /**
	 * This setter allows us to set the route of a delivery plan
	 * @param route delivery route
	 */
    public void setRoute(List<String> route) {
        this.route = route;
    }
    
    /**
	 * This method allows us to add a route to a delivery plan
	 * @param r route to be added
	 */
    public void addRoute(String r) {
        this.route.add(r);
    }

    /**
	 * This getter allows us to get driver associated to the delivery plan
	 * @return list of packages
	 */
    public Driver getDriver(){
        return driver;
    }
    
    /**
	 * This method allows us to add a truck assignment to the list of truckAssignments of a delivery plan
	 * @param ta truck assignment
	 */
    public void addTruckAssignment(TruckAssignment ta) {
    	this.tAssignment.add(ta);
    }

    /**
	 * This setter allows us to set the driver associated to the delivery plan
	 * @param driver driver associated to the delivery plan
	 */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
	 * This getter allows us to get the list of truck assignments
	 * @return list of packages
	 */
    public List<TruckAssignment> getTruckAssignment() {
        return tAssignment;
    }
    
    /**
	 * This method allows us to get the income of a delivery plan
	 * @return inc the income of a delivery plan
	 */
    public double getIncome(){
        double inc = 0.0;

        for(TruckAssignment tA : tAssignment){
            for(Package p: tA.getPackages()){
                inc += p.getPrice();
            }
            
        }
        return inc;
    }
    
    @Override 
    public String toString() {
    	return "Delivery Plan: \n" + this.tAssignment;
    }

    
    
    
    
}