package saveourplanet;

/**
 * Class to represent a Tile .
 * 
 * @author Joy
 *
 */

public class Tile extends Field {
    
	// instance variables
    private int number;
    private String name; 
    private String description;
    private int ecoPointsBuy;
	private int powerPointsBuy;
	private int ecoPointsRent;
	private int powerPointsRent;
	private String owner;

    // Default Constructor

	/*
     * Default Constructor
     */
    public Tile() {

    }

    /**
     * Constructor with args
     * @param number
     * @param name
     * @param description
     */
    public Tile(int number, String name, String description, int ecoPointsBuy, int powerPointsBuy, int ecoPointsRent, int powerPointsRent) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.ecoPointsBuy = ecoPointsBuy;
        this.powerPointsBuy = powerPointsBuy;
        this.ecoPointsRent = ecoPointsRent;
        this.powerPointsRent = powerPointsRent;
    }


    // Getters and Setters

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }


    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
	
	
	public int getEcoPointsBuy() {
		return ecoPointsBuy;
	}

	public void setEcoPointsBuy(int ecoPointsBuy) {
		this.ecoPointsBuy = ecoPointsBuy;
	}

	public int getPowerPointsBuy() {
		return powerPointsBuy;
	}

	public void setPowerPointsBuy(int powerPointsBuy) {
		this.powerPointsBuy = powerPointsBuy;
	}

	public int getEcoPointsRent() {
		return ecoPointsRent;
	}

	public void setEcoPointsRent(int ecoPointsRent) {
		this.ecoPointsRent = ecoPointsRent;
	}

	public int getPowerPointsRent() {
		return powerPointsRent;
	}

	public void setPowerPointsRent(int powerPointsRent) {
		this.powerPointsRent = powerPointsRent;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
