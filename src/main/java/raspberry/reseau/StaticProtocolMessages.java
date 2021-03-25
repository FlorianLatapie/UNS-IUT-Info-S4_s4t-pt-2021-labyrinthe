package raspberry.reseau;

public class StaticProtocolMessages {
	private StaticProtocolMessages() {}
	
	public static final String AVANCER = "A"; 
	public static final String RECULER = "R"; 
	public static final String GAUCHE = "G"; 
	public static final String DROITE = "D"; 
	public static final String STOP = "S";
	public static final String MOUVEMENT_EFFECTUE = "MOUVEMENT:OK";
	
	public static final String ARRIVE = "ARR";
	public static final String TERMINER = "QUIT";
	
	public static final String ENTETE_ALGO = "ALGO:";
	public static final String ALGO_MUR_DROIT = "MUR_DROIT";
	public static final String ALGO_PLEDGE = "PLEDGE";
	
	public static final String RUN_ALGO = "LANCER";
	
	public static final String ENTETE_BROADCAST = "BROADCAST:";

	public static final String ENTETE_CAPTEUR = "VAL_CAPTEUR:";
	public static final String GET_VAL_CAPTEUR = "getCapteur";

	public static final String ENTETE_REGLAGE = "REGLAGE:";
	public static final String VAL_TRIM_GAUCHE = "TRIM_GAUCHE:";
	public static final String VAL_TRIM_DROIT = "TRIM_DROIT:";
	public static final String VAL_AVANCE = "AVANCE:";
	public static final String VAL_ROTATION = "ROTATION:";
	
	public static final String ENTETE_VERBOSE = "VERBOSE:"; 
	public static final String TEST = "test";
	public static final String HELP = "help";
	public static final String COMMANDE_INCONNUE = "commmande inconnue";
	
}
