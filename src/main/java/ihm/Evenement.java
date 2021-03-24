/**
 * 
 */
package ihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Remy
 *
 */

public class Evenement {
	private static final List<IRobotPane> listIRobot = new ArrayList<>();
	private static final List<IAccueilPane> listIAccueil = new ArrayList<>();
	
	
	public static void addListener(IRobotPane toAdd) {
		listIRobot.add(toAdd);
	}
	
	public static void addListener(IAccueilPane toAdd) {
		listIAccueil.add(toAdd);
	}
	
	public static void getAttAlgoSelected() {
		for (IAccueilPane il : listIAccueil) 
			il.getAttAlgoSelected();
	}
	
	public static void deplacementRobot(int[] currentCoord, int[] newCoord) {
		for (IRobotPane rl : listIRobot)
			rl.deplacementRobot(currentCoord, newCoord);
	}
}

