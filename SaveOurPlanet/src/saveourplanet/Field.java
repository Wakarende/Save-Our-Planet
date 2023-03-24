 package saveourplanet;

/**
 * Class that represent the Field
 * @author Joy
 *
 */
public class Field {


	// instance variables
	private String fieldName; 
	private String fieldDescription;

	boolean isOwned;
	
	
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
	 * @param isOwned
	 */
	public Field(String fieldName, String fieldDescription, boolean isOwned) {
		this.fieldName = fieldName;
		this.fieldDescription = fieldDescription;
		this.isOwned = isOwned;
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
	public String getFieldDescription() {
		return fieldDescription;
	}
	
	
	/**
	 * @param fieldDescription
	 */
	public void setFieldDescription(String fieldDescription) {
		this.fieldDescription = fieldDescription;
	}
	
	/**
	 * @return
	 */
	public boolean isOwned() {
		return isOwned;
	}
	
	
	/**
	 * @param isOwned
	 */
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}
	
	

}
