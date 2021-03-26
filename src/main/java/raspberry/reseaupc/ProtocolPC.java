package raspberry.reseaupc;

import ihm.Evenement;
import ihm.RobotPane;
import ihm.TraitementDirection;

public class ProtocolPC {
	private int[] currentCoord;
	private RobotPane robotPane;

	public ProtocolPC(){

	}

	public ProtocolPC(RobotPane pane){
		robotPane = pane;
	}

	public void traitement(String fromServer) {
		//System.out.println(fromServer);
		ihmPaneGauche(fromServer.substring(3));
		ihmPaneDroit(fromServer);
	}

	private void ihmPaneDroit(String fromServer) {
		//System.out.println("fromserver :"+fromServer);
		String valcapteur = fromServer.substring(0,3);
		String directions = fromServer.substring(3);
		Evenement.deplacementRobotVirtuel(valcapteur, directions);
	}

	private void ihmPaneGauche(String fromServer) {
		currentCoord = RobotPane.getCurrentCoordRobot();
		String rotation = RobotPane.getOrientationRobot();
		String[] deplacement = new String[2];
		if (fromServer.length()<=1)
			deplacement[0] = fromServer;
		else
			deplacement = fromServer.split("");
		int[] newCoord =  new TraitementDirection().getdCoordByDeplacement(currentCoord, rotation, deplacement);
		if(fromServer != null) {
			Evenement.deplacementRobot(currentCoord, newCoord);
		}
	}

	public int[] getCurrentCoord() {
		return currentCoord;
	}
	
	public String getAttAlgoSelected() {
		return Evenement.getAttAlgoSelected();
	}
	public String getReglageValeur() {
		return Evenement.getReglageValeur();
	}
	public boolean isTriggered() {
		return Evenement.isTriggered();
	}
}