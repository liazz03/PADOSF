package amazonia.products;

/**
 * This class prints information about food
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public abstract class Food extends Product {

    /*
	 * Constructor of food inheriting from Product
	 */
    public Food(String desc, double weight, double width, double length ,double height){
        super(desc, weight, width, length, height);
    }

    /**
	 * This method allows us to know is the food product has the correct weight
	 * @return True if the food product has its correct weight. False otherwise
	 */
    @Override 
    public boolean isCorrectWeight() {
     	if(this.weight>this._getPrice().getMaxWeightFood()) {
            return false;
        }
        
     	return true;
     }
    
}
