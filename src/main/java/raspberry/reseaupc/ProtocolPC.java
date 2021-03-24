package raspberry.reseaupc;

import ihm.RobotPane;
import ihm.TraitementDirection;

import java.util.Arrays;

public class ProtocolPC {
	private int[] coordRobot;
	private RobotPane robotPane;

	public ProtocolPC(){

	}

	public ProtocolPC(RobotPane pane){
		robotPane = pane;
	}

	public void traitement(String fromServer) {
		System.out.println("je suis passé "+fromServer);
		coordRobot = RobotPane.getCoordRobot();
		System.out.println(Arrays.toString(coordRobot));
		String rotation = RobotPane.getOrientationRobot();
		System.out.println("Rotation : "+rotation);
		String[] deplacement = new String[2];
		if (fromServer.length()<=1)
			deplacement[0] = fromServer;
		else
			deplacement = fromServer.split("");
		System.out.println("Déplacement : "+Arrays.toString(deplacement));
		if(fromServer != null) {
			System.out.println(coordRobot);
			coordRobot = TraitementDirection.getdCoordByDeplacement(coordRobot, rotation, deplacement);
		}

		System.out.println("Nouvelle coordonnée : "+Arrays.toString(coordRobot));
	}

	public int[] getCoordRobot() {
		return coordRobot;
	}
}