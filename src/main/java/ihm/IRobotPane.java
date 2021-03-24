/**
 * 
 */
package ihm;

/**
 * @author Remy
 *
 */
public interface IRobotPane {
	void deplacementRobot(int[] currentCoord, int[] newCoord);
	void deplacementRobotVirtuel(String valCapteur, String directions);
}
