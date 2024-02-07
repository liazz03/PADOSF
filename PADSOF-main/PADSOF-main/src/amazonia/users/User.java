package amazonia.users;
import amazonia.application.*;
import java.io.*;

/**
 * This class prints information about a user
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String name;
    protected String password;

    /**
	 * This constructor allows us to create a user
	 * @param n name of the operator
	 * @param p password of the operator
	 */
    public User(String n, String p) {
        this.name = n;
        this.password = p;
    }

    /**
	 * This getter allows us to get the name of the user
	 * @return name of the user
	 */
    public String getName() {
        return this.name;
    }

    /**
	 * This setter allows us to set the name of the user
	 * @param n name of the user
	 */
    public void setName(String n) {
        this.name = n;
    }

    /**
	 * This getter allows us to get the password of the user
	 * @return password of the user
	 */
    public String getPassword() {
        return this.password;
    }

    /**
	 * This setter allows us to set the password of the user
	 * @param p password of the user
	 */
    public void setPassword(String p) {
        this.password = p;
    }

    /**
	 * Method to return all the information related to a user in a string variable
	 */
    public String toString() {
        return "User: \n" + name + "Password: " + password;
    }

    /**
	 * Method to login into company
     * @param name username
     * @param password password of the user
     * @return True if the user logged in successfully. False otherwise
	 */
    public boolean login(String name, String password){
         return Amazonia.getInstance().login(name, password);
    }

    /**
	 * Method to logout into company
     * @return True if the user logged out successfully. False otherwise
	 */
    public boolean logout(){
        return Amazonia.getInstance().logout();
    }
}