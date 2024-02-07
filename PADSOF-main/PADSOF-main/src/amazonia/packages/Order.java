package amazonia.packages;
import java.io.*;
import java.time.*;

import amazonia.application.Amazonia;
import amazonia.products.*;
import amazonia.users.*;
import es.uam.eps.padsof.invoices.IInvoiceInfo;
import es.uam.eps.padsof.invoices.IProductInfo;
import es.uam.eps.padsof.invoices.NonExistentFileException;
import es.uam.eps.padsof.invoices.UnsupportedImageTypeException;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import es.uam.eps.padsof.invoices.*;
import java.util.*;

/**
 * This class prints information about an order
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Order implements Serializable, IInvoiceInfo {

    /*
     * A unique serial version identifier
     */
	private static final long serialVersionUID = 1L;

	private boolean urgent;
    private LocalDate date;
    private static long nextId = 0;
    private long id;
    private double totalPrice;
    private int reattempts;
    private boolean maxRetries;
    private int currentretries;
    private boolean paid;
    private String address;
    private int postalCode;
    private Company company;
    private OrderStatus status;
    private List<Package> packages = new ArrayList<>();
    private double discount;
    private String UnpaidReason;
    private boolean delivered;

    /**
	 * Constructor that creates a new Order
	 * @param u boolean that checks if the order is urgent
     * @param d date for the order
     * @param maxRetries boolean that represents if the max number of retries has been reached
     * @param paid boolean that checks if the order has been paid
     * @param c company that wants to create the new order
	 */
    public Order(boolean u, LocalDate d, boolean maxRetries, boolean paid, Company c) 
    {
        this.id = nextId++;
        this.urgent = u;
        this.date = d;
        this.reattempts = Operator.OPprice.getReattempts();
        this.maxRetries = maxRetries;
        this.paid = paid;
        this.address = c.getAddress();
        this.postalCode = c.getPostalCode();
        this.company = c;
        this.currentretries=0;
        this.delivered=false;
    }

    /**
	 * This getter allows us to know if the order is urgent
	 * @return true if urgent, false otherwise
	 */
    public boolean isUrgent() {
        return urgent;
    }

    /**
	 * Method to set an order as delivered
	 * @param delivered true if the order is delivered. False otherwise
	 */
    public void setDelivered(boolean delivered){
        this.delivered=delivered;
    }

    /**
	 * Method to get a delivered order
	 * @return true if the order is delivered. False otherwise
	 */
    public boolean getDelivered(){
        return this.delivered;
    }
    
    /**
	 * This setter allows us to set a discount if proceeds
	 * @param Discount boolean, true if proceeds, false otherwise
	 */
    public void setDiscount(double Discount){
        this.discount=Discount;
    }

    /**
	 * This getter allows us to get the id of an order
	 * @return order id
	 */
    public long getId(){
        return this.id;
    }

    /**
	 * This getter allows us to get the date of an order
	 * @return order date
	 */
    public LocalDate getDate() {
        return date;
    }

    /**
	 * This getter allows us to get the total price of an order
	 * @return total price
	 */
    public double getTotalPrice() {
        return totalPrice;
    }
    
    /**
	 * This method allows us to calculate the total price of an order
	 */
    public void CalculateTotalPrice() {
    	double price=0;
        if(this.getUrgent_()){
			price += Operator.OPprice.getUrgent();
        }

        for(Package p: this.getPackages()){
            price = price + p.getPrice();
        }
        if(this.getTotalProducts() > 100) {
        	double discount = price * Operator.OPprice.getDiscount();
        	price = price - discount;
            this.setDiscount(discount);
        }
        System.out.println(price);
        this.totalPrice = price;
    }
    
    /**
	 * This getter allows us to get the total number of products of an order
	 * @return total number of products of an order
	 */
    private int getTotalProducts() {
    	int count=0;
    	for(Package p: this.packages) {
    		count += p.getProducts().size();
    	}
    	return count;
    }

    /**
	 * This getter allows us to get the number of order reattempts
	 * @return number of reattempts
	 */
    public int getReattempts() {
        return reattempts;
    }

    /**
	 * This getter allows us know if the order has reached its maximum number of retries
	 * @return True if the maximum number of retries is reached. False otherwise
	 */
    public boolean getMaxRetries(){
        return this.maxRetries;
    }


    /**
	 * This getter allows us to know if the order is paid
	 * @return true if paid, false otherwise
	 */
    public boolean isPaid() {
        return paid;
    }

    /**
	 * This setter allows us to set if the order is paid
	 * @param paid True if the order is paid. False otherwise
	 */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
	 * This getter allows us to get the address of an order
	 * @return order address
	 */
    public String getAddress() {
        return address;
    }

    /**
	 * This getter allows us to get the postal code of an order
	 * @return postal code
	 */
    public int getCode() {
        return postalCode;
    }

    /**
	 * This getter allows us to get the company
	 * @return company that made the order
	 */
    public Company getCompany() {
        return company;
    }

    /**
	 * This getter allows us to get the status of an order
	 * @return order status
	 */
    public OrderStatus getStatus() {
        return status;
    }

    /**
	 * This setter allows us to set the status of an order
	 * @param st order status
	 */
    public void setStatus(OrderStatus st) {
        this.status=st;
    }
    
    /**
	 * This getter allows us to get the list of packages
	 * @return list of packages
	 */
    public List<Package> getPackages(){
        return this.packages;
    }
    
    /**
     * This method allows us to perform the packaging of an order
     * @param products products of an order to be packed
     */
    public void DoPackaging(List<Product> products) {
    	for(Product p : products) {
    		this.addProductPackage(p);
    	}
    }
    
    /**
     * This method allows us to add a product to a package
     * @param p product to be added to a package
     */
    public void addProductPackage(Product p){
      
           if(p instanceof Fragile){
                   Package pck = new Package( 0, true, false, false,this.id); 
                   pck.addProduct(p);
                   this.packages.add(pck);
                   Amazonia.getInstance().addPackage(pck);
           }
           
           if(p instanceof StandardProduct) {
        	   int ind = this.Package_getInd(2,p.getWeight());
        	   //no standard package available
        	   if(ind==-1) {
        		   Package pck = new Package( 0, false, false, false,this.id);
        		   pck.addProduct(p);
                   this.packages.add(pck);
                   Amazonia.getInstance().addPackage(pck);
        	   }else {
        		   this.packages.get(ind).addProduct(p);
        	   }
           }
           
           if(p instanceof Food) {
        	   int ind = this.Package_getInd(3,p.getWeight());
        	   //no food package available 
        	   if (ind==-1) {
        		   Package pck = new Package( 0, false, false, false,this.id);
        		   pck.addProduct(p);
        		   this.packages.add(pck);
        		   Amazonia.getInstance().addPackage(pck);
        	   }else {
        		   this.packages.get(ind).addProduct(p);
        	   }
           }
           
           if(p instanceof Batch) {
        	   Package pck = new Package( 0, false, true, false,this.id); 
               pck.addProduct(p);
               this.packages.add(pck);
               Amazonia.getInstance().addPackage(pck);
           }
           
    }
    
    /**
     * This method allows us to get the index of a package
     * @param sel auxiliary index to get the index of a package
     * @param weight weight of a package
     * @return integer with the index of a package
     */
    private int Package_getInd(int sel, double weight) {
        int i=0, flag=0;
        if(sel==2) {
        	for(Package p: this.packages){
                if(p.isFull()==false && p.getProducts().get(0) instanceof StandardProduct && p.getWeight() + weight <= Package.maxWeight){
                    flag=1;
                    return i;
                }
                i++;
            }
            if(flag==0) return -1;
        }
        
        if(sel==3) {
        	for(Package p: this.packages){
                if(p.isFull() == false && p.getProducts().get(0) instanceof Food && p.getWeight() + weight <= Package.maxWeight){
                    flag=1;
                    return i;
                }
                i++;
            }
            if(flag==0) return -1;
        }     
        return -1;
        
    }
    
    /**
     * This method allows us to delete a package
     * @param p package to be deleted
     */
    public void DelPackage(Package p) {
    	this.packages.remove(p);
    }

    /**
     * This method allows us to know if an order is urgent
     * @return True if the order is urgent. False otherwise
     */
    public boolean getUrgent_(){
        return this.urgent;
    }

    
    /**
	 * Method that allows us to pay an order
     *
     * @return true if the order was successfully paid, false otherwise
     */
    public boolean payOrder() {  	
    	Company c = this.getCompany();
    	String creditCardN = c.getCardNumber();
    	
    	if(TeleChargeAndPaySystem.isValidCardNumber(creditCardN)) {
    		try {
    			TeleChargeAndPaySystem.charge(creditCardN, "Payment of an Order", this.getTotalPrice(), true);
    			this.setPaid(true);;
    			return true;
    		} catch(InvalidCardNumberException e){
    			System.out.println(e);
    			this.setUnpaidReason("Invalid Card Number");
				return false;
    		} catch (FailedInternetConnectionException e) {
				System.out.println(e);
				this.setUnpaidReason("Internet Connection Failed");
				return false;
			} catch (OrderRejectedException e) {
				System.out.println(e);
				this.setUnpaidReason("Order was Rejected");
				return false;
			}
    	} else {
    		System.out.println("Invalid credit card number. Try again.");
    		return false;
    	}
    }

    /**
     * Method to return information related to an order in a string variable
     */
    public String toString() {
        return "Order:" + "\n\t id: " + id + " \n\t date: " + date + "\n\t total price: " + totalPrice + " \n\t paid: " + paid +
		       "\n\t address: " + address + "\n\t postal code: " + postalCode + "\n\t status: " + status.getStatus() + "\n\t company: " + company.getName();
    }

    @Override
    public String getClientCif() {
        return Long.toString(this.company.getCIF());
    }

    @Override
    public String getCompanyLogo() {
        return "./files/logo.JPG";
    }

    @Override
    public String getCompanyName() {
        return this.company.getName();
    }

    @Override
    public double getDiscount() {
        return this.discount;
    }

    @Override
    public String getOrderDate() {
        return this.date.toString();
    }

    @Override
    public String getOrderIdentifier() {
        return Long.toString(this.id);
    }

    @Override
    public double getPrice() {
        return this.totalPrice;
    }

    @Override
    public double getUrgent() {
        if(this.getUrgent_()){
            return Operator.OPprice.getUrgent();
        }else{
            return 0;
        }
    }

    @Override
    public List<IProductInfo> getProducts(){
        List<IProductInfo> products_ret = new ArrayList<IProductInfo>();
        for(Package p: this.getPackages()){
            for(Product po: p.getProducts()){
                products_ret.add(po);
            }
        }
        return products_ret;
    }

    /**
	 * This getter allows us to get the reason why the order is unpaid in a string variable
	 * @return reason in string variable
	 */
	public String getUnpaidReason() {
		return this.UnpaidReason;
	}

    /**
	 * This setter allows us to set the reason why the order is unpaid in a string variable
	 * @param unpaidReason reason in a string variable 
	 */
	public void setUnpaidReason(String unpaidReason) {
		this.UnpaidReason = unpaidReason;
	}

    /**
	 * Method that allows us to increment the maximum number of attempts
	 */
    public void IncrementMaxAttempts(){
        this.currentretries++;
        if(this.currentretries==this.reattempts){
            this.maxRetries=true;
        }
    }

    /**
	 * This method allows us to know if an invoice has been generated
	 * @return True if the invoice was generated. False otherwise
     */
    public boolean generateInvoice() {
        try {
            InvoiceSystem.createInvoice(this, "./invoices/");
            return true;
        }catch (NonExistentFileException | UnsupportedImageTypeException e){
           System.out.println("Error generating the invoice");
           return false;
        }
    } 

}
