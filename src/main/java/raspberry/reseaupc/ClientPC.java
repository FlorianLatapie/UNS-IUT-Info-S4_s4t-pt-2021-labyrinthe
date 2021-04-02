package raspberry.reseaupc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import ihm.AccueilPane;
import raspberry.reseau.StaticProtocolMessages;

public class ClientPC {
	private String action;
	private ProtocolPC protocolPC = new ProtocolPC();

	public void runClient(String args) {
		if (args == null) {
			System.err.println("aucun argument dans runclient");
			System.exit(1);
		}
		String hostName = args;// "127.0.0.1" ou ip du raspberry pi
		System.out.println("Recherche d'un serveur sur l'IP : " + hostName);
		int portNumber = 8888;
		System.out.println(StaticProtocolMessages.PC + " client lancé");
		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println(StaticProtocolMessages.PC + " client connecté ");
			String fromServer;

			out.println(StaticProtocolMessages.PC);

			new Thread(new Runnable() {
				String fromClient;

				@Override
				public void run() {
					while (true) {
						if (protocolPC.isTriggered()) {
							out.println(protocolPC.getAttAlgoSelected());
							if (protocolPC.getReglageValeur() != null || protocolPC.getReglageValeur() != "") {
								out.println(protocolPC.getReglageValeur());
							}
							out.println(StaticProtocolMessages.RUN_ALGO);
							break;
						}
					}
				}
			}).start();

			while ((fromServer = in.readLine()) != null) {
				if (fromServer.equals(StaticProtocolMessages.TERMINER)) {
					System.exit(0);
				}
				if (fromServer != null) {
					protocolPC.traitement(fromServer);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}

	public void envoyerServeur(String entree, PrintWriter out) {
		out.println(entree);
	}
}
