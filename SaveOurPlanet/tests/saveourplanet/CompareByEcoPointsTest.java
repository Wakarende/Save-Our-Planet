/**
 * 
 */
package saveourplanet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joy
 * Unit Tests for Comparator Class
 *
 */
class CompareByEcoPointsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	
	
	/**
	 * Test method for compareByEcoPoints
	 */
	@Test
	public void testCompareByEcoPoints() {
	    Player p1 = new Player("Alice", 1, 0 , 50);
	    Player p2 = new Player("Bob", 2, 0 ,100);
	    Player p3 = new Player("Charlie", 2, 0, 60);

	    Comparator<Player> comparator = new CompareByEcoPoints();

	    // Test the comparison of p1 and p2
	    int result = comparator.compare(p1, p2);
	    assertTrue(result > 0, "Expected p1 to have more eco points than p2");

	    // Test the comparison of p2 and p3
	    result = comparator.compare(p2, p3);
	    assertTrue(result < 0, "Expected p2 to have fewer eco points than p3");

	    // Test the comparison of p1 and p3
	    result = comparator.compare(p1, p3);
	    assertTrue(result < 0, "Expected p1 to have fewer eco points than p3");

	    // Test the comparison of p1 and p1 (should be equal)
	    result = comparator.compare(p1, p1);
	    assertTrue(result == 0, "Expected p1 and p1 to have the same number of eco points");
	}



}
