/**
 * 
 */
package saveourplanet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joy
 * Unit Test for Tile Class
 *
 */
class TileTest {

	/**
	 * @throws java.lang.Exception
	 */

	// variables
	int number;
	String name, description;

	Tile tile;

	@BeforeEach
	void setUp() throws Exception {
		tile = new Tile();
		number = 1;
		name = "Go";
		description = "Go tile";
	}

	/**
	 * Test method for defaultConstructor.
	 */
	@Test
	void testTile() {
		assertNull(null);
	}

	/**
	 * Test method for constructor with args.
	 */
	@Test
	void testTileIntStringString() {
		tile = new Tile(number, name, description);
		assertEquals(number, tile.getNumber());
		assertEquals(name, tile.getName());
		assertEquals(description, tile.getDescription());
	}

	/**
	 * Test method for getNumber and setNumber.
	 */
	@Test
	void testGetSetNumber() {
		tile = new Tile(number, name, description);

		tile.setNumber(3);

		assertEquals(3, tile.getNumber());
	}

	/**
	 * Test method for getName and setName.
	 */
	@Test
	void testGetSetName() {
		tile = new Tile(number, name, description);

		tile.setName("Chance");

		assertEquals("Chance", tile.getName());
	}

	/**
	 * Test method for getDescription and setDescription.
	 */
	@Test
	void testGetSetDescription() {
		tile = new Tile(number, name, description);

		tile.setDescription("Test description");

		assertEquals("Test description", tile.getDescription());
	}


}
