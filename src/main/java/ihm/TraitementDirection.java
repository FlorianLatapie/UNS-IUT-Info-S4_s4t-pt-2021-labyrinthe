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

	public static int[] getdCoordByDeplacement(int[] coordRobot, String rotationRobot, String[] deplacement) {
		System.out.println("coord "+Arrays.toString(coordRobot)+" rota "+ rotationRobot+" deplaceemnt "+ Arrays.toString(deplacement));
		String rotation = "";
		String direction = "";
		int[] res = new int[2];
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
		} else if (rotationRobot.equals("H") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("G") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("G") && direction.equals("A")) {
			res[0] = (coordRobot[0]) - 1;
			res[1] = coordRobot[1];
			
		} else if (rotationRobot.equals("H") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("A") && direction.equals("")
				|| rotationRobot.equals("B") && rotation.equals("G") && direction.equals("A")) {
			res[0] = coordRobot[0];
			res[1] = (coordRobot[1]) + 1;
			
		} else if (rotationRobot.equals("G") && rotation.equals("G") && direction.equals("A")
				|| rotationRobot.equals("D") && rotation.equals("D") && direction.equals("A")
				|| rotationRobot.equals("B") && rotation.equals("A") && direction.equals("")) {
			res[0] = (coordRobot[0]) + 1;
			res[1] = coordRobot[1];
			
		}
		return res;
	}

}
