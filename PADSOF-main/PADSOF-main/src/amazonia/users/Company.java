package amazonia.users;

import amazonia.application.Amazonia;
import amazonia.packages.*;
import amazonia.products.Product;

import java.io.*;
import java.util.*;

/**
 * This class prints information about a company
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Company extends User {

    private static final long serialVersionUID = 1L;
    private long CIFNumber;
    private String email, address, creditCardNumber;
    private int postalCode;
    private Order order;
    private List<Notification> notifications = new ArrayList<>();

    /**
     * This constructor allows us to create a new Company
     * 
     * @param name       Name of the company
     * @param password   Password of the company
     * @param cardNumber Credit card number of the company
     * @param CIF        CIF number of a company
     * @param email      Email of the company
     * @param address    Address of the company
     * @param code       Postal code of the company
     */
    public Company(String name, String password, String cardNumber, long CIF, String email, String address, int code) {
        super(name, password);

        this.creditCardNumber = cardNumber;
        this.CIFNumber = CIF;
        this.email = email;
        this.address = address;
        this.postalCode = code;
    }

    /**
     * This getter allows us to get the company's card number
     * 
     * @return card number of the company
     */
    public String getCardNumber() {
        return creditCardNumber;
    }

    /**
     * This setter allows us to set the card number of a company
     * 
     * @param card company's credit card number
     */
    public void setCardNumber(String card) {
        this.creditCardNumber = card;
    }

    /**
     * This getter allows us to get the company's CIF number
     * 
     * @return CIF of the company
     */
    public long getCIF() {
        return CIFNumber;
    }

    /**
     * This setter allows us to set the CIF of a company
     * 
     * @param CIF CIF's company
     */
    public void setCIF(long CIF) {
        this.CIFNumber = CIF;
    }

    /**
     * This getter allows us to get the email of the company
     * 
     * @return email of the company
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * This setter allows us to set the email of a company
     * 
     * @param email email of the company
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This getter allows us to get the address of the company
     * 
     * @return address of the company
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * This setter allows us to set the address of a company
     * 
     * @param address company's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This getter allows us to get the postal code of the company
     * 
     * @return postal code of the company
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * This setter allows us to set the postal code of a company
     * 
     * @param code company's postal code
     */
    public boolean setPostalCode(int code) {
        try {
            if(this.checkZIP("files\\zips.txt", code)){
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This getter allows us to get the order of a company
     * 
     * @return order of a company
     */
    public Order getOrder() {
        return order;
    }

    /**
     * This setter allows us to set the order of a company
     * 
     * @param o order to be setted
     */
    public void setOrder(Order o) {
        this.order = o;
    }

    /**
     * This getter allows us to get a company's notification
     * 
     * @return notification of a company
     */
    public List<Notification> getNotifications() {
        return this.notifications;
    }

    /**
     * This setter allows us to set the notification of a company
     * 
     * @param status order status
     * @param o      order related to a company
     */
    public void addNotification(OrderStatus status, Order o) {
        Notification NewNotif = new Notification(NotificationToString(status, o.getId()), o);
        NewNotif.setText(this.NotificationToString(status,o.getId()));
        this.notifications.add(NewNotif);
    }

    /**
     * This method allows us to return a notification in a string variable
     * 
     * @param od order status
     * @param o  text of the order
     */
    private String NotificationToString(OrderStatus od, long o) {
        return "Your Order with id: " + o + " is: " + od;
    }

    /**
     * This method allows us to check a zip code
     * 
     * @param filepath file in which zips are located
     * @param code     postal code
     * @return True if the zip code is valid. False otherwise
     */
    public boolean checkZIP(String filepath, int code) throws FileNotFoundException, IOException {

        Scanner f = new Scanner(new File(filepath));
        int zips;
        while (f.hasNextInt()) {
            zips = f.nextInt();
            if (zips == code) {
                return true;
            }
        }
        f.close();
        return false;
    }

    /**
     * This method allows us to place an order
     * 
     * @param product list of products
     * @param urgent  true if the order is urgent. False otherwise
     * 
     * @return True if the order is placed. False otherwise
     */
    public boolean placeOrder(List<Product> product, boolean urgent) {
        Order order;
        order = Amazonia.getInstance().addOrder(product, urgent, this.name);
        if (order == null) {
            return false;
        } else {
            this.order = order;
            return true;
        }
    }

    /**
     * Method to return information related to a company in a string variable
     */
    public String toString() {
        return "Name: " + super.name + " \n\t Password: " + super.password + " \n\t Credit card number: " + creditCardNumber
                + " \n\t CIFNumber: " + CIFNumber + " \n\t Email: " + email + " \n\t Address: " + address + " \n\t Code: " + 
                postalCode + " \n\t" + this.order + " \n\t Notification: " + this.notifications;
    }

    /**
	 * Method to allow a registration for a company
     * @param name       Name of the company
     * @param password   Password of the company
     * @param cardNumber Credit card number of the company
     * @param CIF        CIF number of a company
     * @param email      Email of the company
     * @param address    Address of the company
     * @param code       Postal code of the company
     * @return True if the company registered successfully. False otherwise
	 */
    public boolean register(String name, String password, String cardNumber, long CIF, String email, String address, int code)  throws FileNotFoundException, IOException {
        return Amazonia.getInstance().registerCompany(name, password, cardNumber, CIF, email, address, code);
    }
}