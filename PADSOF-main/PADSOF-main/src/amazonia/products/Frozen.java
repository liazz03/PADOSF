package amazonia.products;

import java.io.*;

/**
 * This class prints information about frozen food
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Frozen extends Food implements Serializable {

    /*
	 * Constructor of a frozen food inheriting from Food
	 */
    public Frozen(String desc, double weight, double with, double lenght, double height){
        super(desc, weight,with, lenght, height);
    }

    /**
	 * This method allows us to know price of a frozen product
	 * @return price of a frozen product
	 */
    @Override
    public double calculatePrice(){
    	return this._getPrice().getFrozen() * this.weight;
    }

    @Override
    public double getPrice() {
        
        return this.calculatePrice();
    }

    @Override
    public String getPriceDetails() {
        
        return "Frozen food";
    }
    
}
