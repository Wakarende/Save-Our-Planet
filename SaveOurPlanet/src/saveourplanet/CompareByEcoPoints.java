/**
 * 
 */
package saveourplanet;

import java.util.Comparator;

/**
 * @author phil
 *
 */
public class CompareByEcoPoints implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		return p2.getEcoPoints() - p1.getEcoPoints();
	}

}
