package amazonia.products;


/**
 * This class prints information about a fragile product
 * 
 * @author Lia Castaeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Fragile extends Product {
    
    private boolean insured;

    /*
	 * Constructor of a refrigerated food inheriting from Food
     * 
     * @param insured true if the fragile product is insured. False otherwise
	 */
    public Fragile(String desc, double weight, double width, double length, double height, boolean insured) {
        super(desc, weight, width, length, height);
        this.insured = insured;
    }

    /**
	 * This method allows us to know if the fragile product is ensured
	 * @return True if it is ensured. False otherwise
	 */
    public boolean isInsured() {
        return insured;
    }
    
    /**
	 * This method allows us to know price of a fragile product
	 * @return price of a fragile product
	 */
    @Override
    public double calculatePrice() {
    	if(this.insured==true) {
    		return this._getPrice().getTransportInsurance();
    	}else {
    		return this._getPrice().getFragile();
    	}
    }
    
    /**
	 * This method allows us to know is the food product has the correct weight
	 * @return True if the food product has its correct weight. False otherwise
	 */
    @Override public boolean isCorrectWeight() {
    	if(this.weight>this._getPrice().getMaxWeightFragile()) return false;
    	return true;
    }

    @Override
    public double getPrice() {
        return this.calculatePrice();
    }

    @Override
    public String getPriceDetails() {
      
        return "Fragile Product \nInsured Product: " + this.insured;
    }
}
