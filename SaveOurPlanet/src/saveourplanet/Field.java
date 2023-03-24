 package saveourplanet;

/**
 * Class that represent the Field
 * @author joyki
 *
 */
public abstract class Field {


	// instance variables
	private String fieldName; 
	boolean isFieldOwned;
	
	//Constructors
	
	/**
	 * Default Constructor
	 */
	public Field() {
		
	}
	
	/**
	 * constructor with args
	 * @param fieldName
	 * @param fieldDescription
	 * @param isFieldOwned
	 */
	public Field(String fieldName, boolean isFieldOwned) {
		this.fieldName = fieldName;
		this.isFieldOwned = isFieldOwned;
	}
	
	
	//Getters and setters
	
	/**
	 * @return
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	/**
	 * @return
	 */
	public boolean isFieldOwned() {
		return isFieldOwned;
	}
	
	
	/**
	 * @param isFieldOwned
	 */
	public void setOwned(boolean isFieldOwned) {
		this.isFieldOwned = isFieldOwned;
	}
	
	

}
