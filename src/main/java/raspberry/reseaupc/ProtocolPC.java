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
		ihmPaneGauche(fromServer.substring(3));
		ihmPaneDroit(fromServer);
		deplacementRobot(fromServer);
	}

	private void ihmPaneDroit(String fromServer) {
		// ajouter ici l'algo de résolution d'images
	}

	private void ihmPaneGauche(String fromServer) {
		deplacementRobot(fromServer);
	}

	public int[] getCurrentCoord() {
		return currentCoord;
	}
	
	public void deplacementRobot(String fromServer) {

		currentCoord = RobotPane.getCurrentCoordRobot();
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
	
	public void getAttAlgoSelected() {
		Evenement.getAttAlgoSelected();
	}
}