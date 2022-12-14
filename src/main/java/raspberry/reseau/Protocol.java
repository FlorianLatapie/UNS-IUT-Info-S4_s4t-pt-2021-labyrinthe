/**
 * 
 */
package raspberry.reseau;

import raspberry.algo.AlgoDeTremeaux;
import raspberry.algo.AlgoSuivreMurDeDroite;
import raspberry.algo.RecommandationAlgo;

public class Protocol {
	private MultiServer multiServer;
	private RecommandationAlgo recommandationAlgo = new RecommandationAlgo();
	private Boolean verbose = false;

	public Protocol(MultiServer multiServer) {
		this.multiServer = multiServer;
	}

	public Protocol(MultiServer multiServer, Boolean verbose) {
		this.multiServer = multiServer;
		this.verbose = verbose;
	}

	public String processInfo(String input) {

		// si le message est null ou vide, on ne renvoie rien
		if (("" + input).equalsIgnoreCase("" + null) || input.equalsIgnoreCase("")) {
			return "";
		}
		
		// changement de l'algorithme
		else if (input.startsWith(StaticProtocolMessages.ENTETE_ALGO)) {
			input = input.substring(StaticProtocolMessages.ENTETE_ALGO.length());
			switch (input) {
			case StaticProtocolMessages.ALGO_MUR_DROIT:
				recommandationAlgo.changerStrategy(new AlgoSuivreMurDeDroite());
				break;
			case StaticProtocolMessages.ALGO_TREMAUX:
				recommandationAlgo.changerStrategy(new AlgoDeTremeaux());
				break;
			default:
				System.out.println("strat défaut : algo mur droit");
			}
			return "";
		}

		// affiche plus ou moins de messages dans la console
		else if (input.startsWith(StaticProtocolMessages.ENTETE_VERBOSE)) {
			input = input.substring(StaticProtocolMessages.ENTETE_VERBOSE.length());
			switch (input) {
			case "0":
				this.verbose = false;
				break;
			case "false":
				this.verbose = false;
				break;
			case "1":
				this.verbose = true;
				break;
			case "true":
				this.verbose = true;
				break;
			default:
				System.out.println("verbose argument inconnu");

			}
			return "";
		}

		// test du protocole
		else if (input.equalsIgnoreCase(StaticProtocolMessages.TEST)) {
			return StaticProtocolMessages.TEST + " : le protocol existe";
		}

		// affiche de l'aide pour un ClientManuel
		else if (input.equalsIgnoreCase(StaticProtocolMessages.HELP)) {
			return StaticProtocolMessages.HELP + " : " + StaticProtocolMessages.ENTETE_BROADCAST
					+ "<msg> pour envoyer un message à tout le monde";
		}

		// envoie un message à tous les clients 
		else if (input.startsWith(StaticProtocolMessages.ENTETE_BROADCAST)) {
			input = input.substring(StaticProtocolMessages.ENTETE_BROADCAST.length());
			multiServer.sendAll(input);
			return "";
		}

		// lecture du capteur
		else if (input.startsWith(StaticProtocolMessages.ENTETE_CAPTEUR)) {
			if (verbose) {
				System.out.println("execution de l'algo");
			}

			if (input.startsWith(StaticProtocolMessages.ENTETE_CAPTEUR)) {
				String commandes = recommandationAlgo
						.executer(input.substring(StaticProtocolMessages.ENTETE_CAPTEUR.length()));

				if (multiServer.getTabClients().containsKey(StaticProtocolMessages.PC)) {
					multiServer.sendTo(StaticProtocolMessages.PC,
							input.substring(StaticProtocolMessages.ENTETE_CAPTEUR.length()));
				}
				multiServer.sendAll(commandes);

				return "";
			} else {
				System.out.println("erreur algo " + input);
				return "erreur algo " + input;
			}
		}

		// démarrage de l'algorithme ou execution de l'ordre suivant
		if (input.startsWith(StaticProtocolMessages.RUN_ALGO)
				|| input.startsWith(StaticProtocolMessages.MOUVEMENT_EFFECTUE)) {
			if (multiServer.getTabClients().containsKey(StaticProtocolMessages.CAPTEUR)) {
				multiServer.sendToLn(StaticProtocolMessages.CAPTEUR, StaticProtocolMessages.GET_VAL_CAPTEUR);
				return "";
			} else {
				System.out.println("pas de capteur dans la hashmap");
				return "pas de capteur";
			}

		}

		// envoi des réglages à la brique lego 
		if (input.startsWith(StaticProtocolMessages.ENTETE_REGLAGE)) {
			multiServer.sendToLn(StaticProtocolMessages.LEGO, input);
			return "";
		}

		else {
			return "commande inconnue : " + input;
		}
	}

	public Boolean getVerbose() {
		return verbose;
	}

	public void setVerbose(Boolean verbose) {
		this.verbose = verbose;
	}
}
