package saveourplanet;

/**
 * Class to represent a Tile .
 * 
 * @author Joy
 *
 */

public class Tile extends Field{
    
	// instance variables
    private int number;
    private String name; 
    private String description;

    /*
     * Default Constructor
     */
    public Tile() {

    }

	/**
	 * Constructor with arguments for the Tile class. 
	 * Uses the Field class as a super class
	 * @param fieldName
	 * @param isFieldOwned
	 * @param number
	 * @param name
	 * @param description
	 */
	public Tile(String fieldName, boolean isFieldOwned, int number, String name, String description) {
		super(fieldName, isFieldOwned);
		this.number = number;
		this.name = name;
		this.description = description;
	}

	// GETTERS AND SETTERS
	
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

}
