package raspberry.reseaupc;

import ihm.Evenement;
import ihm.RobotPane;
import ihm.TraitementDirection;

import java.util.Arrays;

public class ProtocolPC {
	private int[] currentCoord;
	private RobotPane robotPane;

	public ProtocolPC(){

	}

	public ProtocolPC(RobotPane pane){
		robotPane = pane;
	}

	public void traitement(String fromServer) {
		currentCoord = RobotPane.getCurrentCoordRobot();
		int[] currentTemp = currentCoord;
		String rotation = RobotPane.getOrientationRobot();
		String[] deplacement = new String[2];
		if (fromServer.length()<=1)
			deplacement[0] = fromServer;
		else
			deplacement = fromServer.split("");
		int[] newCoord =  TraitementDirection.getdCoordByDeplacement(currentCoord, rotation, deplacement);
		if(fromServer != null) {
			Evenement.deplacementRobot(currentCoord, newCoord);
		}
	}

	public int[] getCurrentCoord() {
		return currentCoord;
	}
}