package amazonia.packages;

import java.io.*;

/**
 * This class prints information about a notification
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Notification implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text;
    private Order order;
    
    /**
	 * Constructor that creates a new Notification
	 * @param text text for the notification
	 * @param o order for the notification
	 */
    public Notification(String text, Order o) {
        this.text = text;
        this.order = o;
    }

    /**
	 * This getter allows us to get the text of the notification
	 * @return text of the notification
	 */
    public String getText() {
        return this.text;
    }

    /**
	 * This setter allows us to set the text associated to the notification
	 * @param text text to be setted
	 */
    public void setText(String text) {
        this.text = text;
    }

    /**
	 * This getter allows us to get the order associated to the notification
	 * @return order associated to the notification
	 */
    public Order getOrder() {
        return this.order;
    }

    /**
	 * This setter allows us to set the order associated to the notification
	 * @param o order to be setted
	 */
    public void setOrder(Order o) {
        this.order = o;
    }

    public String toString() {
        return this.text;
    }
}
