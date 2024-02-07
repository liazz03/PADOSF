package amazonia.packages;

import amazonia.products.*;

import java.util.*;

/**
 * This class prints information about a batch
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Batch extends Product {
    
    private List<Product> products = new ArrayList<>();

    /**
	 * Constructor that creates a new batch
	 * @param name name for the batch
     * @param products list of products contained in a batch
	 */
    public Batch(String name, List<Product> products) {
        super(name);
        this.products.addAll(products);
    }

    /**
	 * This getter allows us to get a list of products
	 * @return list of products
	 */
    public List<Product> getProducts() {
        return products;
    }

    /**
	 * Function that calculates the price of a batch
	 * @return total price of the batch
	 */
    @Override
    public double calculatePrice() {
    	double total=0;   	
        for(Product p : this.products) {
        	total=total + p.calculatePrice();
        }    
        return total;
    }

    /**
	 * Function that return if the weight is correct
	 * @return true
	 */
	@Override
	public boolean isCorrectWeight() {
		return true;
	}

    /**
	 * Function that adds a product to a batch
	 * @param product product to be added to the batch
	 */
    public void addProduct(Product product) {
        this.products.add(product);
    }
    
    /**
	 * Method to return information related to a batch in a string variable
	 */
    public String toString() {
        return "Name: " + super.description + "List of products: " + this.products;
    }

    @Override
    public double getPrice() {
        return this.calculatePrice();
    }

    @Override
    public String getPriceDetails() {
        return "Batch";
    }
}
