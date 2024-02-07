package amazonia.products;
import amazonia.users.*;
import es.uam.eps.padsof.invoices.IProductInfo;

/**
 * This class prints information about a product
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public abstract class Product implements IProductInfo{
    
    protected String description;
    protected double weight;
    private double width;
    private double height;
    private double length;
    private Price price;
    private boolean specialvolume;
    private int delimspecialvolume = 10;

    /**
	 * Constructor that creates a new Product
     * @param description description of the product
	 * @param weight current weight of a product
     * @param width width of the product
     * @param length length of the product
     * @param height height of the product
	 */
    public Product(String description, double weight, double width, double length, double height) {
        this.description = description;
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
        this.price= Operator.OPprice;
        this.setSpecialVolume(width, length, height);
    }

    /**
	 * Constructor that creates a new Package
     * @param description description of the product
	 */
    public Product(String description) {
        this(description, 0.0, 0.0, 0.0, 0.0);
    }

    /**
	 * This setter allows us to set the special volume of a product
	 * @param x width of a product
     * @param y length of a product
     * @param z height of a product
	 */
    public void setSpecialVolume(double x, double y, double z) {
        if(x>this.delimspecialvolume || y>this.delimspecialvolume || z>this.delimspecialvolume){
            this.specialvolume=true;
        }
    }

    /**
	 * This getter allows us to get the special volume of a product
	 * @return special volume of a product
	 */
    public boolean getSpecialvolume(){
        return this.specialvolume;
    }

    /**
	 * This getter allows us to get the description of a product
	 * @return description of a product
	 */
    public String getDescription() {
        return this.description;
    }

    /**
	 * This setter allows us to set the description of a product
	 * @param desc product's description
	 */
    public void setDescription(String desc) {
    	this.description = desc;
    }
    
    /**
	 * This setter allows us to set the price of a product
	 * @param price product's price
	 */
    public void setPrice(Price price) {
    	this.price = price;
    }
    
    /**
	 * This getter allows us to get the price of a product
	 * @return product's price
	 */
    public Price _getPrice() {
    	return this.price;
    }
    
    /**
	 * This getter allows us to get the maximum weight of a package
	 * @return maximum weight
	 */
    public double getWeight() {
    	return this.weight;
    }

    /**
	 * This setter allows us to set the weight of a product
	 * @param weight product's weight
	 */
    public void setWeight(double weight) {
    	this.weight = weight;
    }

    /**
	 * This getter allows us to get the height of a product
	 * @return maximum height
	 */
    public double getHeight() {
    	return this.height;
    }

    /**
	 * This setter allows us to set the height of a product
	 * @param height product's height
	 */
    public void setHeight(double height) {
    	this.height = height;
    }

    /**
	 * This getter allows us to get the width of a product
	 * @return product's width
	 */
    public double getWidth() {
    	return this.width;
    }

    /**
	 * This setter allows us to set the width of a product
	 * @param width product's width
	 */
    public void setWidth(double width) {
    	this.width = width;
    }
    
    /**
	 * This setter allows us to set the length of a product
	 * @param length product's length
	 */
    public void setLength(double length) {
    	this.length = length;
    }

    /**
	 * This abstract method allows us to calculate the price of a product (overriden by the subclasses)
     * @return price in double format
	 */
    public abstract double calculatePrice();

    /**
	 * This abstract method allows us to check if a product has the correct weight (overriden by the subclasses)
     * @return true if the weight is correct. False otherwise
	 */
    public abstract boolean isCorrectWeight();

    /**
	 * Method to return information related to a product in a string variable
	 */
    public String toString() {
        return "Description: " + description + "weight: " + weight + "width: " + width +
               "height: " + height + "length: " + length;
    }

}
