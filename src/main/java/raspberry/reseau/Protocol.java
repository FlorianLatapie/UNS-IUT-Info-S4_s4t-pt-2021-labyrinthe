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

		if (("" + input).equalsIgnoreCase("" + null) || input.equalsIgnoreCase("")) {
			return "";
		}

		else if (input.startsWith(StaticProtocolMessages.ENTETE_ALGO)) {
			input = input.substring(StaticProtocolMessages.ENTETE_ALGO.length());
			switch (input) {
			case StaticProtocolMessages.ALGO_MUR_DROIT:
				recommandationAlgo.changerStrategy(new AlgoSuivreMurDeDroite());
				break;
			case StaticProtocolMessages.ALGO_PLEDGE:
				recommandationAlgo.changerStrategy(new AlgoDeTremeaux());
				break;
			default:
				System.out.println("strat défaut : algo mur droit");
			}
			return "";
		}

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

		else if (input.equalsIgnoreCase(StaticProtocolMessages.TEST)) {
			return StaticProtocolMessages.TEST + " : le protocol existe";
		}

		else if (input.equalsIgnoreCase(StaticProtocolMessages.HELP)) {
			return StaticProtocolMessages.HELP + " : " + StaticProtocolMessages.ENTETE_BROADCAST
					+ "<msg> pour envoyer un message à tout le monde";
		}

		else if (input.startsWith(StaticProtocolMessages.ENTETE_BROADCAST)) {
			input = input.substring(StaticProtocolMessages.ENTETE_BROADCAST.length());
			multiServer.sendAll(input);
			return "";
		}

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
