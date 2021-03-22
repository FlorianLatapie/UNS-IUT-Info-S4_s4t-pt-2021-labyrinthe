/**
 * 
 */
package pc;

/**
 * @author Remy
 *
 */
public class TraitementDirection {

	public int[] getdCoordByDeplacement(int[] coordRobot, String positionRobot, String[] deplacement) {
		String rotation = null;
		String direction = null;
		if (deplacement.length > 1) {
			rotation = deplacement[0];
			direction = deplacement[1];
		} else {
			direction = deplacement[0];
		}
		if (positionRobot.equals("H") && rotation.equals("G") && direction.equals("A")
				|| positionRobot.equals("G") && rotation.equals(null) && direction.equals("A")
				|| positionRobot.equals("B") && rotation.equals("D") && direction.equals("A")) {
			coordRobot[1] = (coordRobot[1]) - 1;
			return coordRobot;
		} else if (positionRobot.equals("H") && rotation.equals(null) && direction.equals("A")
				|| positionRobot.equals("G") && rotation.equals("D") && direction.equals("A")
				|| positionRobot.equals("D") && rotation.equals("G") && direction.equals("A")) {
			coordRobot[0] = (coordRobot[0]) - 1;
			return coordRobot;
		} else if (positionRobot.equals("H") && rotation.equals("D") && direction.equals("A")
				|| positionRobot.equals("D") && rotation.equals(null) && direction.equals("A")
				|| positionRobot.equals("B") && rotation.equals("G") && direction.equals("A")) {
			coordRobot[1] = (coordRobot[1]) + 1;
			return coordRobot;
		} else if (positionRobot.equals("G") && rotation.equals("G") && direction.equals("A")
				|| positionRobot.equals("D") && rotation.equals("D") && direction.equals("A")
				|| positionRobot.equals("B") && rotation.equals(null) && direction.equals("A")) {
			coordRobot[0] = (coordRobot[1]) + 1;
			return coordRobot;
		}
		return coordRobot;
	}

}
