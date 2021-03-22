package raspberry.reseaupc;

public class ProtocolPC {

	public static boolean traitement(String fromServer) {
		switch (fromServer) {
		case "A":
			//avancer sur l'ig 
			return true;
		case "D":
			//droite sur l'ig 
			return true;
		case "G":
			//gauche sur l'ig 
			return true;
		case "R":
			//reculer sur l'ig 
			return true;
		case "S":
			//avancer sur l'ig 
			return true;
		case "EXIT":
			return true;
		default:
			System.out.println("mouvement inconnu");
			return false;
		}
	}
}