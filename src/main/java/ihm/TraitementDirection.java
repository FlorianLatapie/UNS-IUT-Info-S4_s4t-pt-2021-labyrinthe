/**
 * 
 */
package ihm;

/**
 * @author Remy
 *
 */
public class TraitementDirection {

	public static int[] getdCoordByDeplacement(int[] coordRobot, String rotationRobot, String[] deplacement) {
		System.out.println("yo");
		String rotation = "";
		String direction = "";
		if (deplacement[1] != null) {
			rotation = deplacement[0];
			direction = deplacement[1];
		} else {
			rotation = deplacement[0];
		}
		if (rotationRobot.equals("H") && rotation.equals("G") && direction.equals("A")
				|| rotationRobot.equals("G") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("B") && rotation.equals("D") && direction.equals("A")) {
			coordRobot[1] = (coordRobot[1]) - 1;
			return coordRobot;
		} else if (rotationRobot.equals("H") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("G") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("G") && direction.equals("A")) {
			coordRobot[0] = (coordRobot[0]) - 1;
			return coordRobot;
		} else if (rotationRobot.equals("H") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("B") && rotation.equals("G") && direction.equals("A")) {
			coordRobot[1] = (coordRobot[1]) + 1;
			return coordRobot;
		} else if (rotationRobot.equals("G") && rotation.equals("G") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("B") && rotation.equals("A") && direction.equals("")) {
			coordRobot[0] = (coordRobot[1]) + 1;
			return coordRobot;
		}
		return coordRobot;
	}

}
