package amazonia.packages;

import amazonia.products.*;

import java.util.*;
import java.io.*;


/**
 * This class prints information about a package
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Package implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static long nextId = 0;
    public static final double maxWeight = 50;
    private double weight;
    private long id;
    private boolean fragile, batch, full;
    private double price;
    private long order;
    private List<Product> products = new ArrayList<>();

	/**
	 * Constructor that creates a new Package
     * @param maxWeight maximum weight of a package
	 * @param weight current weight of a package
     * @param fragile true if a package is fragile. False otherwise
     * @param batch true if a package belongs to a batch. False otherwise
     * @param full true if a package is full. False otherwise
	 */
    public Package(double weight, boolean fragile, boolean batch, boolean full) {
        this.weight = weight;
        this.id = nextId++;
        this.fragile = fragile;
        this.batch = batch;
        this.full = full;
        this.price=0;
    }   
    
    public Package( double weight, boolean fragile, boolean batch, boolean full,long order) {
        this.weight = weight;
        this.id = nextId++;
        this.fragile = fragile;
        this.batch = batch;
        this.full = full;
        this.price=0;
        this.order=order;
    }     
    
	/**
	 * This setter allows us to set the current weight of a package
	 * @param weight current weight of a package
	 */
    public void setWeight(int weight) { this.weight = weight; }
    
    /**
	 * This getter allows us to get the weight of a package
	 * @return total price
	 */
    public double getWeight() { return this.weight; }

    /**
	 * This setter allows us to set the id of a package
	 * @param id package's id
	 */
    public void setId(int id) { this.id = id; }

    /**
	 * This getter allows us to get the id of a package
	 * @return total price
	 */
    public long getId() { return this.id; }

    /**
	 * This setter allows us to set a fragile package
	 * @param b fragile package to be setted
	 */
    public void setFragile(boolean b) { this.fragile = b; }

    /**
	 * This method allows us to know if the package is fragile
	 * @return True if it is fragile. False otherwise
	 */
    public boolean isFragile() { return this.fragile; }

    /**
	 * This setter allows us to set the batch in a package
	 * @param b batch to be setted
	 */
    public void setBatch(boolean b) { this.batch = b; }

    /**
	 * This getter allows us to know if the package belongs to a batch
	 * @return total price
	 */
    public boolean getBatch() { return this.batch; }

    /**
	 * This method allows us to know if a package is full
	 * @return True if the package is full. False otherwise
	 */
    public boolean isFull() { return this.full; }

	/**
	 * This setter allows us to set the batch full to true
	 * @param full true if the batch is full
	 */
    public void setFull(boolean full) {
    	this.full=full;
    }
    
	/**
	 * This method allows us to know if a package is full
	 * @return true if the package is full. False otherwise
	 */
    public boolean getFull() {
    	return this.full;
    }

    /**
	 * This getter allows us to get the price of a package
	 * @return price of a package
	 */
    public double getPrice() { 
        return this.price;
    }
    
	/**
	 * This getter allows us to know if a package is fragile
	 * @return True if the package is fragile
	 */
    public boolean getFragile() {
    	return this.fragile;
    }
    
	/**
	 * This setter allows us to set the price of a package
	 * @param price price to be setted
	 */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
	 * This method allows us to add a product to a package
	 * @param p product to be added
	 */
    public boolean addProduct(Product p) {
    	if(this.weight+p.getWeight()>Package.maxWeight) {
    		return false;
    	}
    	if(this.weight+p.getWeight()==Package.maxWeight) {
    		this.setFull(true);
    	}
    	this.weight+=p.getWeight();
        this.products.add(p);
        this.price= this.price + p.calculatePrice();
        return true;
    }
    
	/**
	 * This method allows us to check if a package contains a certain type of product
	 * 
	 * @param sel integer that indicates the type of product
	 * @return True if it contains a certain type of product. False otherwise
	 */
    public boolean containsTYPE(int sel) {
    	if(sel==0) {
    		for(Product p: this.products) {
    			if(p instanceof StandardProduct) {
    				return true;
    			}
    		}
    	}
    	if(sel==1) {
    		for(Product p: this.products) {
    			if(p instanceof Fragile) {
    				return true;
    			}
    		}
    	}
    	if(sel==2) {
    		for(Product p: this.products) {
    			if(p instanceof Frozen) {
    				return true;
    			}
    		}
    	}
    	if(sel==3) {
    		for(Product p: this.products) {
    			if(p instanceof RefrigeratedFood) {
    				return true;
    			}
    		}
    	}
    	if(sel==4) {
    		for(Product p: this.products) {
    			if(p instanceof StandardFood) {
    				return true;
    			}
    		}
    	}
		if(sel==5) {
    		for(Product p: this.products) {
    			if(p.getSpecialvolume()){
					return true;
				}
    		}
    	}
    	return false;
    	
    }
    
    /**
	 * This getter allows us to get a list of products
	 * @return list of products
	 */
    public List<Product> getProducts() {
    	return this.products;
    }

    /**
     * Method to return information related to a package in a string variable
     */
    public String toString() {
        return "Package Id: " + id +  " From Order: " + this.order ;
    }




}