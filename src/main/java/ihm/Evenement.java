/**
 * 
 */
package ihm;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Remy
 *
 */

public class Evenement {
	private static final List<IRobotPane> listIRobot = new ArrayList<>();
	
	
	public static void addListener(IRobotPane toAdd) {
		listIRobot.add(toAdd);
	}
	
	public static void deplacementRobot(int[] currentCoord, int[] newCoord) {
		for (IRobotPane rl : listIRobot)
			rl.deplacementRobot(currentCoord, newCoord);
	}
}

