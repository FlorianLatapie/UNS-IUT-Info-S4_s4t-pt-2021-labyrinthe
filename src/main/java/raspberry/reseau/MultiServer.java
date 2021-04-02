/**
 * 
 */
package raspberry.reseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Remy
 *
 */
public class MultiServer {
	//association client <=> printwriter
	private Map<String, PrintWriter> tabClients = new HashMap<>();

	private int nbClients = 0;

	public void runServer(String[] args) throws IOException {
		int port;
		if (args.length <= 0)
			port = 8888;
		else
			port = Integer.parseInt(args[0]);
		System.out.println("Serveur prêt");
		MultiServer multiServ = new MultiServer();

		try {
			ServerSocket ss = new ServerSocket(port);
			checkConnexion(port);
			while (true) {
				new MultiServerThread(ss.accept(), multiServ);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static void checkConnexion(int port) {
		System.out.println("Serveur en écoute sur le port : " + port);
	}

	/**
	 * envoie un message sur tous les clients
	 * @param message message à envoyer
	 */
	public synchronized void sendAll(String message) {
		for (PrintWriter printWriter : tabClients.values()) {
			if (printWriter != null) {
				printWriter.println(message);
			} else {
				System.err.println("un printwriter est null");
			}
		}
	}

	/**
	 * supprime un client de la hashmap
	 * @param i client
	 */
	public synchronized void delClient(int i) {
		nbClients--;
		if (tabClients.get(i) != null) {
			tabClients.remove(i);
		}
	}

	/**
	 * ajoute un client
	 * @param nom nom du client
	 * @param out PrintWriter de sortie du client
	 * @return taille de la hashmap contenant les clients 
	 */
	public synchronized int addClient(String nom, PrintWriter out) {
		System.out.println(nom + "#" + nbClients + " connecté et ajouté");
		nbClients++;
		tabClients.put(nom, out);
		return tabClients.size() - 1;
	}

	public synchronized int getNbClients() {
		return nbClients;
	}

	public Map<String, PrintWriter> getTabClients() {
		return tabClients;
	}

	/**
	 * prépare l'envoi d'un message à un client SANS retour à la ligne 
	 * @param nomCli destinataire
	 * @param message message 
	 */
	public void sendTo(String nomCli, String message) {
		if (tabClients.containsKey(nomCli)) {
			tabClients.get(nomCli).print(message);
		} else {
			System.out.println("client " + nomCli + " inconnu");
		}

	}

	/**
	 * envoi d'un message à un client AVEC retour à la ligne 
	 * @param nomCli destinataire
	 * @param message message 
	 */
	public void sendToLn(String nomCli, String message) {
		if (tabClients.containsKey(nomCli)) {
			tabClients.get(nomCli).println(message);
		} else {
			System.out.println("client " + nomCli + " inconnu");
		}

	}
}
