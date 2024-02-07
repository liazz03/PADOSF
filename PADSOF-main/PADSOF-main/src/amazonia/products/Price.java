package amazonia.products;

/**
 * This class prints information about the price
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Price {

    private double discount;
    private double frozen;
    private double refrigerated;
    private double transportInsurance;
    private double fragile;
    private double standard_1;
    private double standard_1_5;
    private double standard_5;
    private double urgent;
    private double maxWeightFragile;
    private double maxWeightFood;
    private double maxWeightStandard;
    private int reattempts;

    /*
     * Default constructor to set the prices of several types of products 
     */
    public Price(){
        this.setDiscount(0.1);
        this.setFrozen(1.0);
        this.setRefrigerated(0.5);
        this.setTransportInsurance(5.0);
        this.setFragile(2.0);
        this.setStandard_1(0.4);
        this.setStandard_1_5(0.6);;
        this.setStandard_5(1.0);
        this.setUrgent(5.0);
        this.setReattempts(3);
        this.setMaxWeightFood(30);
        this.setMaxWeightFragile(20);
        this.setMaxWeightStandard(30);
    }

    /**
	 * This setter allows us to set the discount of a product
	 * @param d discount to be setted
	 */
    public void setDiscount(double d){
        this.discount = d;
    }
    
    /**
	 * This getter allows us to get the discount of a product
	 * @return discount of a product
	 */
    public double getDiscount(){
        return this.discount;
    }

    /**
	 * This setter allows us to set the price of a frozen product
	 * @param f frozen price
	 */
    public void setFrozen(double f){
        this.frozen = f;
    }

    /**
	 * This getter allows us to get the price of a frozen product
	 * @return frozen product
	 */
    public double getFrozen(){
        return this.frozen;
    }

    /**
	 * This setter allows us to set the price of a refrigerated product
	 * @param r refrigerated product
	 */
    public void setRefrigerated(double r){
        this.refrigerated = r;
    }

    /**
	 * This getter allows us to get the price of a refrigerated product
	 * @return refrigerated price
	 */
    public double getRefrigerated(){
        return this.refrigerated;
    }

    /**
	 * This setter allows us to set the price of a transport insurance
	 * @param ti transport insurance
	 */
    public void setTransportInsurance(double ti){
        this.transportInsurance = ti;
    }

    /**
	 * This getter allows us to get the price of a transport insurance
	 * @return transport insurance
	 */
    public double getTransportInsurance(){
        return this.transportInsurance;
    }

    /**
	 * This setter allows us to set the price of a standard product lower than a kilo
	 * @param s1 standard product lower than 1 kilo
	 */
    public void setStandard_1(double s1){
        this.standard_1 = s1;
    }

    /**
	 * This getter allows us to get the price of a standard product lower than a kilo
	 * @return price of a product lower than a kilo
	 */
    public double getStandard_1(){
        return this.standard_1;
    }

    /**
	 * This setter allows us to set the price of a standard product between 1 and 5 kilos
	 * @param s1_5 standard product that weighs 1-5 kilos
	 */
    public void setStandard_1_5(double s1_5){
        this.standard_1_5 = s1_5;
    }

    /**
	 * This getter allows us to get the price of a standard product between 1 and 5 kilos
	 * @return price of a product that weighs between 1 and 5 kilos
	 */
    public double getStandard_1_5(){
        return this.standard_1_5;
    }

    /**
	 * This setter allows us to set the price of a standard product higher than 5 kilos
	 * @param s5 standard product that weighs than 5 kilos
	 */
    public void setStandard_5(double s5){
        this.standard_5 = s5;
    }

    /**
	 * This getter allows us to get the price of a standard product
	 * @return price of a product higher than 5 kilos
	 */
    public double getStandard_5(){
        return this.standard_5;
    }

    /**
	 * This getter allows us to get the price of a fragile product
	 * @return price of a fragile product
	 */
	public double getFragile() {
		return fragile;
	}

    /**
	 * This setter allows us to set the price of a fragile product
	 * @param fragile fragile product
	 */
	public void setFragile(double fragile) {
		this.fragile = fragile;
	}

    /**
	 * This getter allows us to get the price of an urgent product
	 * @return price of an urgent product
	 */
    public double getUrgent() {
		return this.urgent;
	}
    
    /**
	 * This setter allows us to set the price of an urgent product
	 * @param urgent urgent product
	 */
    public void setUrgent(double urgent) {
        this.urgent = urgent;
    }

    /**
	 * This getter allows us to get the maximum weight of a fragile product
	 * @return maximum weight of a fragile product
	 */
    public double getMaxWeightFragile(){
        return this.maxWeightFragile;
    }

    /**
	 * This setter allows us to set the maximum weight of a fragile product
	 * @param w weight of the fragile product
	 */
    public void setMaxWeightFragile(double w) {
		this.maxWeightFragile= w;
	}

    /**
	 * This getter allows us to get the maximum weight of a standard product
	 * @return maximum weight of a standard product
	 */
    public double getMaxWeightStandard(){
        return this.maxWeightStandard;
    }

    /**
	 * This setter allows us to set the maximum weight of a standard product
	 * @param w maximum weight of the standard product
	 */
    public void setMaxWeightStandard(double w) {
		this.maxWeightStandard= w;
	}

    /**
	 * This getter allows us to get the maximum weight of a food product
	 * @return maximum weight of a food product
	 */
    public double getMaxWeightFood(){
        return this.maxWeightFood;
    }

    /**
	 * This setter allows us to set the maximum weight of a food product
	 * @param w weight of the food product
	 */
    public void setMaxWeightFood(double w) {
		this.maxWeightFood= w;
	}

    /**
	 * This getter allows us to get the number of reattempts
	 * @return number of reattempts
	 */
	public int getReattempts() {
		return reattempts;
	}
	
    /**
	 * This setter allows us to set the number of reattempts
	 * @param reattempts number of reattempts
	 */
    public void setReattempts(int reattempts) {
		this.reattempts = reattempts;
	}
    
    public String toString() {
    	return this.discount +" "+ this.fragile + this.frozen + this.maxWeightFood + this.maxWeightFragile + 
    			this.maxWeightStandard + this.reattempts + this.refrigerated + this.standard_1 + this.standard_1_5 + 
    			this.standard_5 + this.transportInsurance + this.urgent ;
    }
}