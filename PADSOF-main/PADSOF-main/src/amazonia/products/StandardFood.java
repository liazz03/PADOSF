package amazonia.products;

import java.io.*;

/**
 * This class prints information about a standard food
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class StandardFood extends Food implements Serializable {

	/*
	 * Constructor of a standard food inheriting from Product
	 */
    public StandardFood(String desc, double weight, double with, double lenght, double height){
        super(desc, weight, with, lenght,height);
    }
    
	/**
	 * This method allows us to calculate the price of standard food
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

	@Override
	public double getPrice() {
		
		return this.calculatePrice();
	}

	@Override
	public String getPriceDetails() {
		
		return "Standard Food Product";
	}

}