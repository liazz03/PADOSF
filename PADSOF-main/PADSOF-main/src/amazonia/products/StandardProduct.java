package amazonia.products;

import java.io.*;

/**
 * This class prints information about a standard product
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class StandardProduct extends Product implements Serializable {
    
	/*
	 * Constructor of a standard product inheriting from Product
	 */
	public StandardProduct(String desc, double weight, double width, double length, double height){
        super(desc, weight, width, length,height);
    }
	
	/**
	 * This method allows us to calculate the price of standard product
	 */
    @Override
    public double calculatePrice() {
    	if(this.weight<=1) {
    		return this._getPrice().getStandard_1();
    	}else if( this.weight>1 && this.weight<=5) {
    		return this._getPrice().getStandard_1_5();
    	}else {
    		return this._getPrice().getStandard_5();
    	}
    
    }
    
	/**
	 * This method allows us to check if a standard product's weight is correct
	 * 
	 * @return True if the weight is correct. False otherwise
	 */
    @Override 
	public boolean isCorrectWeight() {
    	if(this.weight>this._getPrice().getMaxWeightStandard()) return false;
    	return true;
    }

	@Override
	public double getPrice() {
		return this.calculatePrice();
	}

	@Override
	public String getPriceDetails() {
		return "Standard Product";
	}
}