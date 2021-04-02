/**
 * 
 */
package ihm;

import java.util.Arrays;

/**
 * @author Remy
 *
 */
public class TraitementDirection {

	public int[] getdCoordByDeplacement(int[] coordRobot, String rotationRobot, String[] deplacement) {
		String rotation = "";
		String direction = "";
		int[] res = new int[3];
		if (deplacement[1] != null) {
			rotation = deplacement[0];
			direction = deplacement[1];
		} else {
			rotation = deplacement[0];
		}
		if (rotationRobot.equals("H") && rotation.equals("G") && direction.equals("A")
				|| rotationRobot.equals("G") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("B") && rotation.equals("D") && direction.equals("A")) {
			res[0] = coordRobot[0];
			res[1] = (coordRobot[1]) - 1;
			res[2] = 0; // image vers la gauche
		} else if (rotationRobot.equals("H") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("G") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("G") && direction.equals("A")) {
			res[0] = (coordRobot[0]) - 1;
			res[1] = coordRobot[1];
			res[2] = 1; // image vers le haut

		} else if (rotationRobot.equals("H") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("B") && rotation.equals("G") && direction.equals("A")) {
			res[0] = coordRobot[0];
			res[1] = (coordRobot[1]) + 1;
			res[2] = 2; // image vers la droite;

		} else if (rotationRobot.equals("G") && rotation.equals("G") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("B") && rotation.equals("A") && direction.equals("")) {
			res[0] = (coordRobot[0]) + 1;
			res[1] = coordRobot[1];
			res[2] = 3; // image vers le bas;

		} else {
			res[0] = coordRobot[0];
			res[1] = coordRobot[1];
			res[2] = getOppositeIdRotation(rotationRobot);
		}
		return res;
	}

	public int getOppositeIdRotation(String currRotation) {
		switch (currRotation) {
		case "H":
			return 3;
		case "B":
			return 1;
		case "G":
			return 2;
		case "D":
			return 0;
		default:
			return 1;

		}
	}

}
