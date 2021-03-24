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
		System.out.println("je suis passé "+fromServer);
		currentCoord = RobotPane.getCurrentCoordRobot();
		String rotation = RobotPane.getOrientationRobot();
		System.out.println("Rotation : "+rotation);
		String[] deplacement = new String[2];
		if (fromServer.length()<=1)
			deplacement[0] = fromServer;
		else
			deplacement = fromServer.split("");
		System.out.println("Déplacement : "+Arrays.toString(deplacement));
		int[] newCoord =  TraitementDirection.getdCoordByDeplacement(currentCoord, rotation, deplacement);
		if(fromServer != null) {
			System.out.println("new coord : "+Arrays.toString(newCoord));
			System.out.println("Current coord : "+Arrays.toString(currentCoord));
			Evenement.deplacementRobot(currentCoord, newCoord);
		}
	}

	public int[] getCurrentCoord() {
		return currentCoord;
	}
}