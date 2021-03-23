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
		coordRobot = robotPane.getCoordRobot();
		String rotation = robotPane.getOrientationRobot();
		String[] deplacement = new String[2];
		if (fromServer.length()<=1) {
			deplacement[0] = fromServer;
		}
		else{
			deplacement = fromServer.split("");
		}
		System.out.println(Arrays.toString(deplacement));
		if(fromServer != null)
			coordRobot = new TraitementDirection().getdCoordByDeplacement(coordRobot, rotation, deplacement);
	}

	public int[] getCoordRobot() {
		return coordRobot;
	}
}