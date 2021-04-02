/**
 * 
 */
package ihm;

/**
 * @author Remy
 *
 */
public interface IRobotPane {
	void deplacementRobot(int[] currentCoord, int[] newCoord); // définition de la méthode deplacementRobot dans l'interface

	void deplacementRobotVirtuel(String valCapteur, String directions); // définition de la méthode deplacementRobotVirtuel dans l'interface
}
