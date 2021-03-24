package raspberry.reseaulego;

import lego.MouvementController;
import raspberry.reseau.StaticProtocolMessages;

public class ProtocolLego {

	public boolean traitement(String fromServer) {
		MouvementController mouvementController = new MouvementController(true);
		switch (fromServer) {
		case StaticProtocolMessages.AVANCER:
			mouvementController.avancer();
			return true;
		case StaticProtocolMessages.DROITE:
			mouvementController.droite();
			return true;
		case StaticProtocolMessages.GAUCHE:
			mouvementController.gauche();
			return true;
		case StaticProtocolMessages.RECULER:
			mouvementController.reculer();
			return true;
		case StaticProtocolMessages.STOP:
			mouvementController.stop();
			return true;
		default:
			System.out.println("mouvement inconnu\n"+fromServer);
			return false;
		}
	}
}
