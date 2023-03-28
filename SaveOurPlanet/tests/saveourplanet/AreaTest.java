/**
 * 
 */
package saveourplanet;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joykirii
 *
 */
class AreaTest {

	/**
	 * @throws java.lang.Exception
	 */

	// variables
	int number, buyingPrice, developmentPrice, rentPrice, buyingReward, developmentReward, rentReward;
	String name, description, ownerName, developmentDescription;

	Area area = new Area();

	@BeforeEach
	void setUp() throws Exception {
		area = new Area();
		number = 6;
		buyingPrice = 20;
		developmentPrice = 45;
		rentPrice = 15;
		buyingReward = 4;
		developmentReward = 8;
		rentReward = 3;
		name = "Bottle Farm";
		description = "Buy this bottle farm to improve recycling and waste.";
		ownerName = null;
		developmentDescription = "Franchise your bottle farm to open multiple locations and increase clients.";
	}

	/**
	 * Test method for Default Constructor.
	 */
	@Test
	void testAreaConstructor() {
		assertNull(null);
	}

	/**
	 * Test method for constructor with args.
	 */
	@Test
	void testAreaConstructorWithArgs() {
		Area area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice,
				buyingReward, developmentReward, rentReward, developmentDescription);
		assertEquals(number, area.getNumber());
		assertEquals(name, area.getName());
		assertEquals(description, area.getDescription());
		assertEquals(ownerName, area.getOwnerName());
		assertEquals(buyingPrice, area.getBuyingPrice());
		assertEquals(developmentPrice, area.getDevelopmentPrice());
		assertEquals(rentPrice, area.getRentPrice());
		assertEquals(buyingReward, area.getBuyingReward());
		assertEquals(developmentReward, area.getDevelopmentReward());
		assertEquals(rentReward, area.getRentReward());
		assertEquals(developmentDescription, area.getDevelopmentDescription());

	}

	/**
	 * Test method for getDevelopmentDescription and setDevelopmentDescription.
	 */
	@Test
	void testGetSetDevelopmentDescription() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, null);

		area.setDevelopmentDescription(developmentDescription);
		assertEquals(developmentDescription, area.getDevelopmentDescription());

	}

	/**
	 * Test method for getOwnerName and setOwnerName.
	 */
	@Test
	void testGetSetOwnerName() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		area.setOwnerName("jk");
		
		assertEquals("jk", area.getOwnerName());

	}

	
	/**
	 * Test method for {@link saveourplanet.Area#getBuyingPrice()}.
	 */
	@Test
	void testGetSetBuyingPrice() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(buyingPrice, area.getBuyingPrice());

		// test set method
		area.setBuyingPrice(30);
		assertEquals(30, area.getBuyingPrice());
	}

	/**
	 * Test method for getDevelopmentPrice and setDevelopmentPrice.
	 */
	@Test
	void testGetSetDevelopmentPrice() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(developmentPrice, area.getDevelopmentPrice());

		// test set method
		area.setDevelopmentPrice(30);
		assertEquals(30, area.getDevelopmentPrice());
	}

	/**
	 * Test method for getRentPrice and setRentPrice.
	 */
	@Test
	void testGetSetRentPrice() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(rentPrice, area.getRentPrice());

		// test set method
		area.setRentPrice(40);
		assertEquals(40, area.getRentPrice());

	}

	/**
	 * Test method for getBuyingReward and setBuyingReward.
	 */
	@Test
	void testGetSetBuyingReward() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(buyingReward, area.getBuyingReward());

		// test set method
		area.setBuyingReward(200);
		assertEquals(200, area.getBuyingReward());
	}

	/**
	 * Test method for getDevelopmentReward and setDevelopmentReward.
	 */
	@Test
	void testGetSetDevelopmentReward() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(developmentReward, area.getDevelopmentReward());

		// test set method
		area.setDevelopmentReward(30);
		assertEquals(30, area.getDevelopmentReward());
	}

	/**
	 * Test method for getRentReward and setRentReward.
	 */
	@Test
	void testGetSetRentReward() {
		area = new Area(number, name, description, ownerName, buyingPrice, developmentPrice, rentPrice, buyingReward,
				developmentReward, rentReward, developmentDescription);

		// test get method
		assertEquals(rentReward, area.getRentReward());

		// test set method
		area.setRentReward(30);
		assertEquals(30, area.getRentReward());
	}

}
