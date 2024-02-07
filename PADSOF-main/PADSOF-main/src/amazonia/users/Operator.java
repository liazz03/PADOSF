package amazonia.users;

import amazonia.products.*;
import amazonia.packages.*;
import amazonia.packages.Package;
import amazonia.application.Amazonia;
import amazonia.trucks.*;
import java.util.*;
import java.time.*;


/**
 * This class prints information about an operator
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Operator extends User {

	private static final long serialVersionUID = 1L;
	private List<Order> orders = new ArrayList<>();
    public static Price OPprice = new Price();
    
    /**
	 * This constructor allows us to create a new Operator
	 * @param n name of the operator
	 * @param p password of the operator
	 */
    public Operator(String n, String p) {
        super(n, p);
    }
    

    /**
	 * This getter allows us to get the operator's name
	 * @return name of the operator
	 */
    public String getName() {
        return super.name;
    }

    /**
	 * This setter allows us to set the name of the operator
	 * @param n name of the operator
	 */
    public void setName(String n) {
        super.name = n;
    }

    /**
	 * This getter allows us to get the password of an operator
	 * @return password of the operator
	 */
    public String getPassword() {
        return super.password;
    }

    /**
	 * This setter allows us to set the password
	 * @param p password of the operator
	 */
    public void setPassword(String p) {
        super.password = p;
    }
    
    /**
	 * Method that creates an order for a company
     * @param product list of products
     * @param urgent boolean for urgent orders
     * @param c company for which the order will be created
     * @param date date in which the order was created
	 */
    public Order createOrder(List<Product> product, boolean urgent, Company c, LocalDate date) {
        Order order = new Order( urgent, date, false, false, c);
        order.DoPackaging(product);
        order.CalculateTotalPrice();
        if(!checkProductsWeight(product)){
            return null;
        }
        if(order.payOrder()){
            order.setPaid(true);
            order.setStatus(OrderStatus.RECEIVEDANDVALIDATED);
            this.orders.add(order);
            Amazonia.getInstance().addOrder(order);
            Amazonia.getInstance().notifyCompany(c.getName(),OrderStatus.RECEIVEDANDVALIDATED,order);
            return order;
        }
        return null;
    }
    
    /**
	 * Method that checks the weight of a product
	 * @param product list of product to check weights
     * @return true if the weight is correct, false otherwise
     */
    private boolean checkProductsWeight(List<Product> product){
        for(Product p: product){
            if(!p.isCorrectWeight()) return false;    
        }
        return true;
    }
    
    
    /**
	 * Method that allows us to create the delivery plan
     * @return the delivery plan
	 */
    public DeliveryPlan createDeliveryPlan() {  
    	
        DeliveryPlan p = new DeliveryPlan(); 
        List<Order> orders = this.orders;
		int i=0;
		
        for(Truck t: Amazonia.getInstance().getTrucks()) {
  
        	if(t.getType().equals(TruckType.STANDARD)) {
        		TruckAssignment ta = new TruckAssignment(t);
        		for(Order o: orders) {
                	if(o.getUrgent_() && o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)) {
                		for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                			Package pack = it.next();
                				if(!pack.containsTYPE(2) && !pack.containsTYPE(3) && !pack.containsTYPE(5)) { // FALTA VER BATCH//
                    				ta.addPackage(pack); 
                                    Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                    it.remove();
                    			}
                		}
                	}
                	i++;
                }
        		i=0;
        		
        		for(Order o: orders) {
                    if(o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)){
                        for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                        	Package pack = it.next();
                        	if(!pack.containsTYPE(2) && !pack.containsTYPE(3) && !pack.containsTYPE(5)) { // FALTA VER BATCH//
                				ta.addPackage(pack); 
                                Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                it.remove();
                			}
                		}
                    }
                    i++; 
        		}
        		p.addTruckAssignment(ta);
        		i=0;
        	}
        	
        	if(t.getType().equals(TruckType.REFRIGERATED)) {
        		TruckAssignment ta = new TruckAssignment(t);
        		for(Order o: orders) {
                	if(o.getUrgent_() && o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)) {
                		for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                			Package pack = it.next();
                        	if(!pack.containsTYPE(4) && !pack.containsTYPE(1) && !pack.containsTYPE(5)) { // FALTA VER BATCH//
                				ta.addPackage(pack); 
                                Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                it.remove();
                			}
                		}
                	}
                	i++;
                }
        		i=0;
        		for(Order o: orders) {
                    if(o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)){
                    	for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                			Package pack = it.next();
                        	if(!pack.containsTYPE(4) && !pack.containsTYPE(1) && !pack.containsTYPE(5)) { // FALTA VER BATCH//
                				ta.addPackage(pack); 
                                Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                it.remove();
                			}
                		}
                    }
                    i++;
        		}
        		p.addTruckAssignment(ta);
        		i=0;
        	}
        	
        	if(t.getType().equals(TruckType.SPECIALVOLUME)) {
                TruckAssignment ta = new TruckAssignment(t);
                for(Order o: orders) {
                	if(o.getUrgent_() && o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)) {
                		for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                			Package pack = it.next();
                        	if(pack.containsTYPE(5)) { // FALTA VER BATCH//
                				ta.addPackage(pack); 
                                Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                it.remove();
                			}
                		}
                	}
                	i++;
                }
                i=0;
                for(Order o: orders) {
                    if(o.getStatus().equals(OrderStatus.RECEIVEDANDVALIDATED)){
                    	for(ListIterator<Package> it = o.getPackages().listIterator(); it.hasNext();) {
                			Package pack = it.next();
                        	if(pack.containsTYPE(5)) { // FALTA VER BATCH//
                				ta.addPackage(pack); 
                                Amazonia.getInstance().notifyCompany(orders.get(i).getCompany().getName(), OrderStatus.INDELIVERY,orders.get(i));
                                it.remove();
                			}
                		}
                    }
        			i++;
        		}
                p.addTruckAssignment(ta);
                i=0;
            }
        }

        return p;
    }

    /**
	 * This method allows us to set the order as delivered
	 * @param id id of the order
	 */
    public void setOrderDelivered(long id) {
        int ind = this.getOrderInd(id);
        this.orders.get(ind).setDelivered(true);
    }

    /** 
	 * This getter allows us to get the index of an order
	 * @param id id of the order
	 */
    private int getOrderInd(long id) {
        int i=0;
        for(Order o : this.orders) {
            if(o.getId()==id) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
	 * This method allows us to get the income per month
     * @param m month to get the income
	 * @return income per month
	 */
    public double getIncomePerMonth(Month m) {
        double inc = 0.0;

        if(m == null){
            return -1;
        }
        for(Order o: Amazonia.getInstance().getOrders()) {
            if(o.getDate().getMonthValue() == m.getValue()) {
                inc += o.getTotalPrice();

            }
        }
        
        return inc;
    }

    /**
	 * This method allows us to get the average income per month
     * @param m month to get average income
	 * @return average income per month
	 */
    public double getAvgIncomePerOrderPerMonth(Month m) {
        double inc = 0.0;
        int numOrders = 0;

        numOrders = Amazonia.getInstance().getOrders().size();
        if(numOrders < 1){
            return -1;
        }

        inc = this.getIncomePerMonth(m) / numOrders;

        return inc;
    }

    /**
	 * This method allows us to get the number of orders per month
     * @param m month to get the number of orders per month
	 * @return number of orders per month
	 */
    public int getOrdersPerMonth(Month m) {
         int numOrders = 0;
        
        for(Order o: Amazonia.getInstance().getOrders()) {
            if(o.getDate().getMonthValue() == m.getValue()) {
                numOrders++;

            }
        }

        return numOrders;
    }

    /**
	 * This method allows us to get the number of packages per month
     * @param m month to get the number of packages per month
	 * @return number of packages per month
	 */
    public int getNumPackagesPerMonth(Month m) {
        int numPackages = 0;


        for(Order o: Amazonia.getInstance().getOrders()){
             if(o.getDate().getMonthValue() == m.getValue()) {
                numPackages += o.getPackages().size();
             }
        }

        return numPackages;
    }
    
    /**
	 * This method allows us to get the number of packages delivered per month
     * @param m month to get the number of packages delivered per month
	 * @return number of packages delivered per month
	 */
    public int getNumPackagesDelivered(Month m) {
        int numPackages = 0;
        
        for(Order o: Amazonia.getInstance().getOrders()){
            if((o.getDate().getMonthValue() == m.getValue()) && (o.getStatus() == OrderStatus.DELIVERED)) {
                numPackages += o.getPackages().size();
            }
        }
        return numPackages;
    }

    /**
	 * This method allows us to get the number of packages Non-delivered per month
     * @param m month to get the number of packages Non-delivered per month
	 * @return number of packages Non-delivered per month
	 */
    public int getNumPackagesNonDelivered(Month m) {
        int numPackages = 0;

        for(Order o: Amazonia.getInstance().getOrders()){
             if((o.getDate().getMonthValue() == m.getValue()) && (o.getStatus() == OrderStatus.NONDELIVERED)) {
                numPackages += o.getPackages().size();
             }
        }
        
        return numPackages;
    }

    /**
     * Method to return all the information related to the operator in a string variable
     */
    public String toString() {
        return "Name: " + super.name + " \n\tPassword: " + super.password;
    }

    /**
	 * This method allows The operator to add a driver assignment
	 */
    public boolean addDriverAssignment(String name, String Licenseplate){
       return Amazonia.getInstance().addDriverAssignment(name, Licenseplate);     
    }
    
    public void setTruckFixed(String Licenseplate) {
    	Amazonia.getInstance().setTruckFixed(Licenseplate);
    }

    /**
	 * This method allows The operator to register a Driver
	 * @return true if driver was successfully created false otherwise
	 */
    public boolean registerDriver(String name, String password, long phoneNum){
        return Amazonia.getInstance().registerDriver(name, password, phoneNum);
    }
}