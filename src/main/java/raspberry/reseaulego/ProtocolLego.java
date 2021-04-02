package raspberry.reseaulego;

import lego.MouvementController;
import raspberry.reseau.StaticProtocolMessages;

public class ProtocolLego {

	public boolean traitement(String fromServer) {
		MouvementController mouvementController = new MouvementController(true);
		
		// Réglage du robot
		if (fromServer.startsWith(StaticProtocolMessages.ENTETE_REGLAGE)) {
			fromServer = fromServer.substring(StaticProtocolMessages.ENTETE_REGLAGE.length());
			if (fromServer.startsWith(StaticProtocolMessages.VAL_AVANCE)) {
				return true;
			} else if (fromServer.startsWith(StaticProtocolMessages.VAL_ROTATION)) {
				mouvementController.setRotation(
						Double.parseDouble(fromServer.substring(StaticProtocolMessages.VAL_ROTATION.length())));
				return true;
			} else if (fromServer.startsWith(StaticProtocolMessages.VAL_AVANCE)) {
				mouvementController.setDistance(
						Double.parseDouble(fromServer.substring(StaticProtocolMessages.VAL_AVANCE.length())));
				return true;
			} else if (fromServer.startsWith(StaticProtocolMessages.VAL_TRIM_GAUCHE)) {
				mouvementController.setDistance(
						Double.parseDouble(fromServer.substring(StaticProtocolMessages.VAL_TRIM_GAUCHE.length())));
				return true;
			} else if (fromServer.startsWith(StaticProtocolMessages.VAL_TRIM_DROIT)) {
				mouvementController.setDistance(
						Double.parseDouble(fromServer.substring(StaticProtocolMessages.VAL_TRIM_DROIT.length())));
				return true;
			} else {
				return false;
			}
		} 
		
		// Déplacement du robot 
		else {
			switch (fromServer) {
			case StaticProtocolMessages.GAUCHE + StaticProtocolMessages.AVANCER:
				mouvementController.gauche();
				mouvementController.avancer();
				return true;
			case StaticProtocolMessages.DROITE + StaticProtocolMessages.AVANCER:
				mouvementController.droite();
				mouvementController.avancer();
				return true;
			case StaticProtocolMessages.GAUCHE + StaticProtocolMessages.GAUCHE:
				mouvementController.gauche();
				mouvementController.gauche();
				return true;
			case StaticProtocolMessages.DROITE + StaticProtocolMessages.DROITE:
				mouvementController.droite();
				mouvementController.droite();
				return true;

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
				System.out.println("mouvement inconnu\n" + fromServer);
				return false;
			}
		}
	}
}
