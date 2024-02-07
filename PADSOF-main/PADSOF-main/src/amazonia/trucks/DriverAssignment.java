package amazonia.trucks;
import java.io.Serializable;

import amazonia.users.*;

/**
 * This class prints information about a Driver Assignment
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class DriverAssignment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Driver driver;
	private TruckAssignment ta;
	
	/**
	 * Constructor that creates a new Driver assignment
	 * @param driver driver of the assignment
	 * @param ta truck assignment associated to the driver
	 */
	public DriverAssignment(Driver driver, TruckAssignment ta) {
		this.driver=driver;
		this.ta=ta;
	}
	
	/**
	 * Method to get the driver of an assignment
	 * @return driver associated to assignment
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * Method to set the driver of an assignment
	 * @param driver driver to be setted
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
	 * This getter allows us to get a truck assignment
	 * @return truck assignment
	 */
	public TruckAssignment getTruckAssignment() {
		return ta;
	}

	/**
	 * Method to set the truck assignment
	 * @param ta truck assignment 
	 */
	public void setTruckAssignment(TruckAssignment ta) {
		this.ta = ta;
	}
	
	public String toString() {
		return "Driver: " + this.driver.getName() + " Truck Assignment: \n" + this.ta; 
	}
}
