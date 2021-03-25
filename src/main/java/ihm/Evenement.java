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
	private static final List<IAccueilPane> listIAccueil = new ArrayList<>();
	
	
	public static void addListener(IRobotPane toAdd) {
		listIRobot.add(toAdd);
	}
	
	public static void addListener(IAccueilPane toAdd) {
		listIAccueil.add(toAdd);
	}
	
	public static String getAttAlgoSelected() {
		for (IAccueilPane il : listIAccueil) 
			return il.getAttAlgoSelected();
		return null;
	}
	
	public static void deplacementRobot(int[] currentCoord, int[] newCoord) {
		for (IRobotPane rl : listIRobot)
			rl.deplacementRobot(currentCoord, newCoord);
	}
	
	public static void deplacementRobotVirtuel(String valcapteur, String directions) {
		for (IRobotPane rl : listIRobot)
			rl.deplacementRobotVirtuel(valcapteur, directions);
	}

	public static String getReglageValeur(){
		for(IAccueilPane il : listIAccueil){
			return il.getReglageValeur();
		}
		return null;
	}

	public static boolean isTriggered(){
		for (IAccueilPane il : listIAccueil){
			return il.isTriggered();
		}
		return false;
	}
}

