package amazonia.application;

import amazonia.packages.*;
import amazonia.packages.Package;
import amazonia.products.*;
import amazonia.trucks.*;
import amazonia.users.*;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

/**
 * This class manages the application of the system
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Amazonia implements Serializable {
    
    /*
     * A unique serial version identifier
     */
    public static final long serialVersionUID = 1L;
    
    private static Amazonia amazonia = null;

    private Operator operator;
    private User currentUser;
    private DeliveryPlan deliveryplan;
    private List<Truck> trucks;
    private ArrayList<User> users;
    private List<Order> orders;
    private List<Driver> drivers;
    private List<Company> companies;
    private List<Package> packages;
    private List<DriverAssignment> driverAssignments;
    
    /**
	 * This getter allows us to get application (Amazonia) instance
	 * @return Amazonia instance
	 */
    public static Amazonia getInstance() {
        if(amazonia == null) {
            amazonia = new Amazonia();
        }

        return amazonia;
    }

    /**
	 * This constructor allows us to create a new Amazonia App
	 */
    public Amazonia() {
        this.operator = new Operator("amazonia", "amazonia");
        this.trucks = new ArrayList<>();
        try {
			this.loadTrucks("files\\fleet.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        this.users = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.deliveryplan = new DeliveryPlan();
        this.companies = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.currentUser = null;
        this.packages= new ArrayList<>();
        this.driverAssignments= new ArrayList<>();
        this.users.add(operator);
    }

    /**
	 * This getter allows us to get the list of trucks
	 * @return list of trucks
	 */
    public List<Truck> getTrucks() {
        return trucks;
    }

    /**
	 * This method allows us to add a driver to the list of drivers
	 * @param d driver to be added
	 */
    public void addDrivers(Driver d){
        this.drivers.add(d);
        this.users.add(d);
    }

    /**
	 * This getter allows us to get the list of drivers
	 * @return list of drivers
	 */
    public List<Driver> getDrivers() {
        return drivers;
    }
    
    /**
	 * This getter allows us to get the current user of the application
	 * @return current user
	 */
    public User getCurrentUser(){
        return this.currentUser;
    }
    
    /**
	 * This setter allows us to set the current user of the application
	 * @param cU current user
	 */
    public void setCurrentUser(User cU){
        this.currentUser = cU;
    }

    /**
	 * This setter allows us to set the trucks
	 * @param trucks list of trucks
	 */
    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }
    
    /**
	 * This method allows us to add a truck to the list of trucks of Amazonia
	 * @param t truck to be added
	 */
    public void addTruck(Truck t) {
        this.trucks.add(t);
    }
    
    /**
	 * This getter allows us to get the list of users of Amazonia
	 * @return users list of users
	 */
    public List<User> getUsers() {
        return this.users;
    }

    /**
	 * This getter allows us to get the list of orders of Amazonia
	 * @return orders list of orders
	 */
    public List<Order> getOrders() {
        return orders;
    }

    /**
	 * This setter allows us to set the orders
	 * @param ord list of orders
	 */
    public void setOrders(List<Order> ord) {
        this.orders = ord;
    }
    
    /**
	 * This method allows us to add an order to the list
	 * @param o order to be added
	 */
    public void addOrder(Order o) {
        this.orders.add(o);
    }
    
    /**
	 * This getter allows us to get the list of companies
	 * @return companies list of companies
	 */
    public List<Company> getCompanies() {
        return this.companies;
    }
    
    /**
	 * This method allows us to add a company to the list of companies
	 * @param e company to be added
	 */
    public void addCompany(Company e){
        this.companies.add(e);
        this.users.add(e);
    }
    
    /**
	 * This method allows us to set a delivery plan
	 */
    public void setDeliveryPlan(){
        this.deliveryplan = this.operator.createDeliveryPlan();
    }
    
    /**
	 * This method allows the operator to create an order for a company
	 * @param product list of products that will contain the order
	 * @param urgent boolean parameter that determines if the order is urgent (true or false)
	 * @param name company name that wants to create an order
     * @return order added
	 */
    public Order addOrder(List<Product> product, boolean urgent, String name){
        Order ord =  this.operator.createOrder(product, urgent, this.getCompanyRef(name), LocalDate.now());
        this.getCompanies().get(getCompanyInd(name)).setOrder(ord);
       
        return ord;
    }
    
    /**
	 * This getter allows us to get the delivery plan
	 * @return delivery plan
	 */
    public DeliveryPlan getDeliveryPlan(){
        return this.deliveryplan;
    }
    
    /**
	 * This getter allows us to get the reference of a company
	 * @param name company name
	 * @return company's reference
	 */
    private Company getCompanyRef(String name){
        for(Company cmp : this.companies){
            if(cmp.getName().equals(name)){
                return cmp;
            }
        }
        return null;
    }
    
    /**
	 * This method allows us to load trucks from a file
	 * @param filepath path where the file is located
	 */
    public void loadTrucks(String filepath) throws FileNotFoundException, IOException{ 
        Scanner f = new Scanner(new File(filepath));
        String buff;

        while(f.hasNextLine()){
            Truck t = new Truck();
            buff = f.nextLine();
            StringTokenizer st = new StringTokenizer(buff,":");
             while (st.hasMoreTokens()) {  
                t.setLicensePlate(st.nextToken()); 
                t.setMaxWeight(Integer.parseInt(st.nextToken()));
                String type = st.nextToken();
                if(type.equals("SPECIAL")){
                    t.setType(TruckType.SPECIALVOLUME);
                }else if(type.equals("STANDARD")){
                    t.setType(TruckType.STANDARD);
                }else{
                    t.setType(TruckType.REFRIGERATED);
                }   
            }
            
            this.trucks.add(t);  
        }

        f.close();
    }
    
    /**
	 * This method allows us the companies get notified
	 * @param name name of the company
	 * @param status status of the order
	 * @param o order
	 */
    public void notifyCompany(String name, OrderStatus status, Order o){
        this.companies.get(getCompanyInd(name)).addNotification(status, o);
    }
    
    /**
	 * This method allows The operator to add a driver assignment
	 */
    public boolean addDriverAssignment(String name, String Licenseplate){
        Driver driver = null;
        TruckAssignment tack = null;
        
        for(Driver d: Amazonia.getInstance().getDrivers()) {
        	if(d.getName().equals(name)) {
        		driver = d;
        	}
        }
        
        for(TruckAssignment ta: Amazonia.getInstance().getDeliveryPlan().getTruckAssignment()) {
        	if(ta.getTruck().getLicensePlate().equals(Licenseplate)) {
        		tack=ta;
        	}
        }
        
        if(driver == null || tack == null ) return false;
        
        DriverAssignment da = new DriverAssignment(driver, tack);
        this.driverAssignments.add(da);

        return true;
        
    }
    
    
    /**
	 * This method allows us to set an operator for the application
	 * @param operator operator to be setted
	 */
    public void setOperator(Operator operator) {
    	this.operator = operator;
    	this.users.add(operator);
    }

    /**
	 * This method allows us to get the operator of the application
	 * @preturn operator operator to be setted
	 */
    public Operator getOperator() {
    	return this.operator;
    }
    
    /**
	 * This method allows us to get a company index (id)
	 * @param name name of the company
	 * @return index (id) of the company
	 */
    public int getCompanyInd(String name){
        int i=0;
        for(Company comp : this.companies){
            if(comp.getName().equals(name)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public void addPackage(Package pack) {
    	this.packages.add(pack);
    }

    /**
	 * Method to login a user given its name and password
	 * @param name username
	 * @param password password of the user
	 * @return User if it exists. False otherwise
	 */
    public boolean login(String name, String password) {
        for(User u : this.getUsers()) {
            if(u.getName().equals(name) && u.getPassword().equals(password)) {
                this.currentUser = u;
                return true;
            }
        }
        return false;
    }
    
    public void setTruckFixed(String LicensePlate) {
    	for(Truck t : this.trucks) {
    		if(t.getLicensePlate().equals(LicensePlate)) {
    			t.setBroken(false);
    		}
    	}
    }

    /**
	 * Method to set an order as delivered
	 * @param id id of the order
	 */
    public boolean setDelivered(long id){

        int ind = getOrderInd(id);
        if(ind==-1) return false;
        this.orders.get(ind).setDelivered(true); // set amazonia order as delivered
        this.operator.setOrderDelivered(id); // set operators order reference as deliverd
        this.companies.get(this.getCompanyInd(this.orders.get(ind).getCompany().getName())).getOrder().setDelivered(true); // set company order as delivered
        this.orders.get(ind).getCompany().addNotification(OrderStatus.DELIVERED,  this.orders.get(ind)); // add notification
        this.orders.get(ind).generateInvoice(); // generate invoice
        return true;
    }

    /**
	 * Method to set an order as non-delivered
	 * @param id id of the order
	 */
    public boolean setNotDelivered(long id){

        int ind = getOrderInd(id);
        if(ind == -1) return false;
        this.orders.get(ind).IncrementMaxAttempts(); // increment attempts 
        this.notifyCompany(this.orders.get(ind).getCompany().getName(),OrderStatus.NONDELIVERED, this.orders.get(ind)); // add notification

        //if max retries reached notify
        if(this.orders.get(ind).getMaxRetries()){
            this.notifyCompany( this.orders.get(ind).getCompany().getName(),OrderStatus.MAXATTEMPTSREACHED, this.orders.get(ind)); // add notification
        }
        
        return true;
    }
    
    /**
	 * Method to get the index of an order
	 * @param id id of the order
     * @return integer as an order index
	 */
    private int getOrderInd(long id){
    
        int i=0;
        for(Order o : this.orders){
            if(o.getId()==id){
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
	 * Method to logout a user
	 * @return True if the user is logged out. False otherwise
	 */
    public boolean logout(){
        if(this.getCurrentUser().equals(Amazonia.getInstance().getCurrentUser()) == false) {
            return false;
        }

        this.currentUser = null;
        return true;
    }

    /**
	 * Method to save the data of the application given a Object Stream
	 * @param filename file to save the data from the app
	 */
    public void save(String filename) throws IOException {
        PrintWriter pw = new PrintWriter(filename);
        pw.close();
        try {
            ObjectOutputStream fileData = new ObjectOutputStream(new FileOutputStream(filename));
            

            fileData.writeObject(users);
            fileData.writeObject(operator);
            fileData.writeObject(trucks);
            fileData.writeObject(orders);
            fileData.writeObject(deliveryplan);
            fileData.writeObject(currentUser);
            fileData.writeObject(drivers);
            fileData.writeObject(companies);
            fileData.writeObject(packages);
            fileData.writeObject(driverAssignments);
            
            fileData.close();
            
        } catch(IOException ex) {
            throw ex;
        };
    }

     /**
	 * Method to load the data of the application given a file
	 * @param filename file to load the app data
	 */
    @SuppressWarnings("unchecked")
    public void load(String filename) throws IOException, ClassNotFoundException{
        try{
           ObjectInputStream fileData = new ObjectInputStream(new FileInputStream(filename));;

            
            users = (ArrayList<User>) fileData.readObject();
            operator = (Operator) fileData.readObject();
            trucks = (List<Truck>) fileData.readObject();
            orders = (List<Order>) fileData.readObject();
            deliveryplan = (DeliveryPlan) fileData.readObject();
            currentUser = (User) fileData.readObject();
            drivers = (List<Driver>) fileData.readObject();
            companies = (List<Company>) fileData.readObject();
            packages = (List<Package>) fileData.readObject();
            driverAssignments = (List<DriverAssignment>) fileData.readObject();
            
            fileData.close();
        } catch(IOException ex) {
            throw ex;
        };
    }

    /**
	 * Method to register a company given its data
     * @param name       Name of the company
     * @param password   Password of the company
	 * @param cardNumber Credit card number of the company
     * @param CIF        CIF number of a company
     * @param email      Email of the company
     * @param address    Address of the company
     * @param code       Postal code of the company
     * 
     * @return True if the company is successfully registered. False otherwise
	 */
    public boolean registerCompany(String name, String password, String cardNumber, long CIF,
        String email, String address, int code) throws FileNotFoundException, IOException {
    	Company c = new Company(name, password, cardNumber, CIF, email, address, code);
        
    	if (c.checkZIP("files\\zips.txt", code) == false) {
            return false;
        }
    	
    	for(Company comp: this.companies) {
    		if(comp.getPassword().equals(c.getPassword())) {
    			return false;
    		}
    	}
        
        this.addCompany(c);

        return true;
    }
    
    /**
	 * Method to set a truck as broken
	 * @param licensePlate license plate of broken truck
	 */
    public void setBrokenTruck(String licensePlate){
        int i=0;
        for(Truck t : this.getTrucks()){
            if(t.getLicensePlate().equals(licensePlate)){
                this.getTrucks().get(i).setBroken(true);
            }
            i++;
        }
    }

    /**
	 * Method to register a driver given its data
	 * @param name        Name of the driver
     * @param password    Password of the driver
     * @param phoneNum Phone number of the driver
     * @return True if the driver is successfully registered. False otherwise
	 */
    public boolean registerDriver(String name, String password, long phoneNum) {
    	Driver d = new Driver(name, password, phoneNum);
    	
    	for(Driver driv: this.drivers) {
    		if(driv.getPassword().equals(d.getPassword())) {
    			return false;
    		}
    	}
    	
    	
        this.addDrivers(d);
        return true;
    }
    
    /**
	 * Method that prints all users' data
	 */
    public void printAllUsers() {
        System.out.println("--- USERS ---");
        for(User u : users) {
            System.out.println(u);
        }

        System.out.println("--------------");
    }

    /**
	 * Method that prints all trucks' data
	 */
    public void printAllTrucks() {
        System.out.println("--- TRUCKS ---");
        for(Truck t : trucks) {
            System.out.println(t);
        }

        System.out.println("--------------");
    }

    /**
	 * Method that prints all orders' data
	 */
    public void printAllOrders() {
        System.out.println("--- ORDERS ---");
        for(Order o : orders) {
            System.out.println(o);
        }

        System.out.println("--------------");
    }
    
    public void printDeliveryPlan() {
    	 System.out.println("--- DELIVERY PLAN ---");
    	 System.out.println(this.deliveryplan);
    }
    
    public void printDriverAssignments() {
   	 System.out.println("--- DRIVER ASSIGNMENTS ---");
   	 System.out.println(this.driverAssignments);
   }
}