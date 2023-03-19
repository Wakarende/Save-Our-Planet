package saveourplanet;

/**
 * Class to represent a Tile .
 * 
 * @author Joy
 *
 */

public class Tile extends Field{
    // instance variables
    int number;
    String name, description;

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
    public Tile(int number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
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

}
