package raspberry.reseau;

public class StaticProtocolMessages {
	public final static String AVANCER = "A"; 
	public final static String RECULER = "R"; 
	public final static String GAUCHE = "G"; 
	public final static String DROITE = "D"; 
	public final static String STOP = "S";
	
	public final static String ARRIVE = "ARR";
	public final static String TERMINER = "QUIT";
	
	public final static String ENTETE_ALGO = "ALGO:";
	public final static String ALGO_MUR_DROIT = "MUR_DROIT";
	
	public final static String ENTETE_BROADCAST = "BROADCAST:";

	public final static String ENTETE_CAPTEUR = "VAL_CAPTEUR:";
	
	public final static String ENTETE_VERBOSE = "VERBOSE:"; 
	public final static String TEST = "test";
	public final static String HELP = "help";
	public final static String COMMANDE_INCONNUE = "commmande inconnue";
}
