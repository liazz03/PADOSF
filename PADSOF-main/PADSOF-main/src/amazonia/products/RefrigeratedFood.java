package amazonia.products;

import java.io.*;

/**
 * This class prints information about a refrigerated food
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class RefrigeratedFood extends Food implements Serializable {

   /*
	 * Constructor of a refrigerated food inheriting from Food
	 */
   public RefrigeratedFood(String desc, double weight, double with, double length, double height) {
      super(desc, weight,with, length, height);
   }
     
   /**
	 * This method allows us to calculate the price of refrigerated food
	 */
   @Override
   public double calculatePrice() {
    	return this._getPrice().getRefrigerated() * this.weight;
   }

   @Override
   public double getPrice() {
      return this.calculatePrice();
   }

   @Override
   public String getPriceDetails() {
      return "Refrigerated Product";
   }

}