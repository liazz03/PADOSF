package amazonia.packages;

/**
 * This enumeration prints information about the status of an order
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public enum OrderStatus {

    /*
    * Delivered status
    */
    DELIVERED,

    /*
    * Maximum of attempts reached status
    */
    MAXATTEMPTSREACHED,

    /*
    * Received and validated status
    */
    RECEIVEDANDVALIDATED, // Driver no 

    /*
    * In delivery status
    */
    INDELIVERY,

    /*
    * Non delivered
    */
    NONDELIVERED;

    private String str;

    public String getStatus() {
        return str;
    }
}