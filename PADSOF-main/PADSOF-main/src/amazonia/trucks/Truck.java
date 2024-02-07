package amazonia.trucks;

import java.io.*;

/**
 * This class prints information about a truck
 * 
 * @author Lia Castañeda lia.castanneda@estudiante.uam.es
 * @author Miguel Blas miguel.blasg@estudiante.uam.es
 * @author Marcos Parra marcos.parra@estudiante.uam.es
 */
public class Truck implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private static int nextId = 0;
    private double maxWeight;
    private String licensePlate;
    private boolean broken;
    private TruckType type;
    private boolean full;

    /**
	 * Constructor that creates a new Truck
	 * @param weight weight of a truck
     * @param licensePlate license plate of a truck
     * @param broken true if a truck is broken. False otherwise
     * @param full true if a truck is full. False otherwise
	 */
    public Truck (double weight, String licensePlate, boolean broken, boolean full, TruckType type) {
        this.id = nextId++;
        this.maxWeight = weight;
        this.licensePlate = licensePlate;
        this.broken = false;
		this.full = false;
		this.type = type;
    }

	/*
	 * Default constructor to create a truck 
	 */
    public Truck(){
		this.id = nextId++;
        this.setFull(false);
		this.broken = false;
		this.full = false;
		
    }

    /**
	 * This setter allows us to set the id of a truck
	 * @param id id of a truck
	 */
    public void setId(int id) { this.id = id; }

    /**
	 * This getter allows us to get the id of a truck
	 * @return id of the truck
	 */
    public int getId() { return this.id; }

    /**
	 * This setter allows us to set the maximum weight of a truck
	 * @param m maximum weight of a truck
	 */
    public void setMaxWeight(int m) { this.maxWeight = m; }

    /**
	 * This getter allows us to get the weight of a truck
	 * @return weight of a truck
	 */
    public double getMaxWeight() { return this.maxWeight; }

    /**
	 * This setter allows us to set the truck's license plate
	 * @param l license plate of the truck
	 */
    public void setLicensePlate(String l) { this.licensePlate = l; }

    /**
	 * This getter allows us to get the truck's license plate
	 * @return license plate of a truck
	 */
    public String getLicensePlate() { return this.licensePlate; }

    /**
	 * This setter allows us to set a broken truck
	 * @param b True if it is broken. False otherwise
	 */
    public void setBroken(boolean b) { this.broken = b; }

    /**
	 * This getter allows us to know if a truck is broken
	 * @return True if the truck is broken. False otherwise
	 */
    public boolean getBroken() { return this.broken; }

    /**
	 * This getter allows us to get the truck's type
	 * @return type of truck
	 */
    public TruckType getType() {
        return type;
    }

    /**
	 * This setter allows us to set the type of the truck
	 * @param type Truck type
	 */
    public void setType(TruckType type) {
        this.type = type;
    }

    /**
	 * This method allows us to check if a truck is full
	 * @return True if a truck is full. False otherwise
	 */
	public boolean isFull() {
		return full;
	}

    /**
	 * This setter allows us to set if the truck if full
	 * @param full true if the truck is full. False otherwise
	 */
	public void setFull(boolean full) {
		this.full = full;
	}
	
	/**
	 * This method prints info about the truck in a String
	 */
	@Override 
	public String toString() {
		return this.licensePlate + " " + this.maxWeight + " " + this.type;
	}
}