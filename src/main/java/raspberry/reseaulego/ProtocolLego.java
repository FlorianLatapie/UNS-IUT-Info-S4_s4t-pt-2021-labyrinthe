package raspberry.reseaulego;

import lego.MouvementController;

public class ProtocolLego {

	public boolean traitement(String fromServer) {
		MouvementController mouvementController = new MouvementController(true);
		switch (fromServer) {
		case "A":
			mouvementController.avancer();
			return true;
		case "D":
			mouvementController.droite();
			return true;
		case "G":
			mouvementController.gauche();
			return true;
		case "R":
			mouvementController.reculer();
			return true;
		case "S":
			mouvementController.stop();
			return true;
		case "EXIT":
			return true;
		default:
			System.out.println("mouvement inconnu");
			return false;
		}
	}
}
