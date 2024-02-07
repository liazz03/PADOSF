package amazonia.trucks;

import java.io.Serializable;
import java.util.*;

import amazonia.packages.Package;

/**
 * This class prints information about a truck assignment
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class TruckAssignment implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Truck truck;
    private List<Package> packs;

    /**
	 * Constructor that creates a new Package
     * @param t Truck which belongs to the truck assignment
	 */
    public TruckAssignment(Truck t) {
        this.truck = t;
        this.packs = new ArrayList<>();;
    }

    /**
	 * This getter allows us to get the truck of an assignment
	 * @return truck of an assignment
	 */
    public Truck getTruck() {
        return this.truck;
    }

    /**
	 * This getter allows us to get list of packages
	 * @return list of packages
	 */
    public List<Package> getPackages() {
        return this.packs;
    }

    /**
	 * This method allows us to add a package to a truck assignment
	 * @param pa package to be added
	 */
    public void addPackage(Package pa) {
        this.packs.add(pa);
    }
    
    @Override 
    public String toString() {
    	return this.truck + ": " + this.packs + "\n";
    }
    
    
    
    
    
    
}
