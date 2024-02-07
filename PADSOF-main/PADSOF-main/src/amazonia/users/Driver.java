package amazonia.users;

import amazonia.application.*;
/**
 * This class prints information about the drivers
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Driver extends User {

	private static final long serialVersionUID = 1L;
	private long phoneNumber;

    /**
     * Constructor that creates a new Driver
     * @param name        Name of the driver
     * @param password    Password of the driver
     * @param phoneNum Phone number of the driver
    */
    public Driver(String name, String password, long phoneNum) {
        super(name, password);
        this.phoneNumber = phoneNum;
    }

    /**
	 * This getter allows us to get the phone number of a driver
	 * @return driver's phone number
	 */
    public long getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
	 * This setter allows us to set the phone number of a driver
	 * @param pN driver's phone number
	 */
    public void setPhoneNumber(long pN) {
        this.phoneNumber = pN;
    }

    /**
	 * Method to allow a driver set an order as delivered manually
     * @param id id of the order
	 */
    public void setDelivered(long id) {
        Amazonia.getInstance().setDelivered(id);
    }

    /**
	 * Method to allow a driver set an order as non-delivered manually
     * @param id id of the order
	 */
    public void NotDelivered(long id) {
        Amazonia.getInstance().setNotDelivered(id);
    }

    /**
	 * This method allows us to check the name of a driver
     * @param name name to be checked
	 * @return True if the names are different. False other
	 */
    public boolean checkName(String name) {
        if(super.name == name) {
            return false;
        }
        return true;
    }

    /**
     * Method to return information related to a driver in a string variable
     */
    public String toString() {
        return "Name: " + super.name + " \n\t Password: " + super.password + "\n\t Phone number: " + phoneNumber;
    }
    
    
    /**
     * Method for driver to set a truck as brroken
     * @param LicensePlate truck to set broken
     */
    public void reportBroken(String LicensePlate) {
        Amazonia.getInstance().setBrokenTruck(LicensePlate);
    }
}